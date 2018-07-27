public class Board {
    private String[] locations;

    public Board(){
        this.locations = generateEmptyBoard();
    }

    public String[] getLocations(){
        return locations;
    }

    private String[] generateEmptyBoard(){
        String[] boardLocations = new String[9];

        for (int i = 0; i < 9; i++) {
            String numberAsString = Integer.toString(i);
            boardLocations[i] = numberAsString;
        }
        return boardLocations;
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
    }
}
