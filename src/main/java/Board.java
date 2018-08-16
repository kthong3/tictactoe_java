import java.util.*;

public class Board {
    {
        generateEmptyBoard();
    }

    private String[] locations;

    public String[] locations(){
        return locations;
    }

    public void setLocations(String[] locations){
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

    public boolean isFilled(){
        List currentBoard = Arrays.asList(locations());
        String[] originalBoard = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        List originalBoardList = Arrays.asList(originalBoard);

        return Collections.disjoint(currentBoard, originalBoardList);
    }

    public boolean determineWinner(Player player){
        return (checkForUniqueChars(locations[0], locations[1], locations[2]) == player.symbol()) || (checkForUniqueChars(locations[3], locations[4], locations[5]) == player.symbol());
    }

    private String checkForUniqueChars(String spot1, String spot2, String spot3){
        String[] firstRow = new String[] {spot1, spot2, spot3};
        Set set = new HashSet();
        for (String spot : firstRow) {
            set.add(spot);
        }
        if (set.size() == 1){
            return spot1;
        }
        else return "spots are different";
    }
}
