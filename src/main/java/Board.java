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
        String row1 = "";
        String row2 = "";
        String row3 = "";
        for (int i = 0; i < 9; i++) {
            if (i > 5){
                if (i == 8){
                    row3 += locations[i];
                }
                else
                    row3 += locations[i] + " | ";
            }

            if (i > 2 && i < 6){
                if (i == 5){
                    row2 += locations[i];
                }
                else
                    row2 += locations[i] + " | ";
            }


            if (i >= 0 && i < 3){
                if (i == 2){
                    row1 += locations[i];
                }
                else
                    row1 += locations[i] + " | ";
            }


        }

        System.out.println(row1);
        System.out.println("---------");
        System.out.println(row2);
        System.out.println("---------");
        System.out.println(row3);
    }
}
