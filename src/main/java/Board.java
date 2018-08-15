import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {
    {
        generateEmptyBoard();
    }

    private String[] locations;

    public String[] locations(){
        return locations;
    }

    private void setLocations(String[] locations){
        this.locations = locations;
    }

    private void generateEmptyBoard(){
        String[] boardLocations = new String[9];
        for (int i = 0; i < 9; i++) {
            String numberAsString = Integer.toString(i);
            boardLocations[i] = numberAsString;
        }
        setLocations(boardLocations);
    }

    public void display(){
        String row1 = String.format("%s | %s | %s", locations[0], locations[1], locations[2]);
        String row2 = String.format("%s | %s | %s", locations[3], locations[4], locations[5]);
        String row3 = String.format("%s | %s | %s", locations[6], locations[7], locations[8]);

        System.out.println(row1);
        System.out.println("---------");
        System.out.println(row2);
        System.out.println("---------");
        System.out.println(row3);
        System.out.println();
    }

    public void markLocation(String chosenLocation, Player player){
        int spot = Integer.parseInt(chosenLocation);
        locations[spot] = player.symbol();
    }

    public boolean locationAlreadyTaken(String chosenLocation){
        int spot = Integer.parseInt(chosenLocation);
        return !locations[spot].contains(chosenLocation);
    }
}
