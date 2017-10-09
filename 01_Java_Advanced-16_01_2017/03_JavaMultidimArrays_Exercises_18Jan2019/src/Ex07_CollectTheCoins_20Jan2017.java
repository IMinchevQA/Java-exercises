import java.util.Locale;
import java.util.Scanner;

public class Ex07_CollectTheCoins_20Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scan = new Scanner(System.in);
        char[][] map = fillTheMap(scan);
        char[] moves = scan.nextLine().toCharArray();
        int coins = 0;
        int wallHits = 0;
        int rowPosition = 0;
        int colPosition = 0;

        for (char move : moves) {
            switch(move){
                case '<':
                    if(checkIfMoveIsPossible(map, rowPosition, colPosition - 1)){
                        colPosition--;
                        if(map[rowPosition][colPosition] == '$'){
                            coins++;
                        }
                    } else {
                        wallHits++;
                    }
                    break;
                case '>':
                    if(checkIfMoveIsPossible(map, rowPosition, colPosition + 1)){
                        colPosition++;
                        if(map[rowPosition][colPosition] == '$'){
                            coins++;
                        }
                    } else {
                        wallHits++;
                    }
                    break;
                case '^':
                    if(checkIfMoveIsPossible(map, rowPosition - 1, colPosition)){
                        rowPosition--;
                        if(map[rowPosition][colPosition] == '$'){
                            coins++;
                        }
                    } else {
                        wallHits++;
                    }
                    break;
                case 'V':
                    if(checkIfMoveIsPossible(map, rowPosition + 1, colPosition)){
                        rowPosition++;
                        if(map[rowPosition][colPosition] == '$'){
                            coins++;
                        }
                    } else {
                        wallHits++;
                    }
                    break;
            }
        }
        System.out.printf("Coins = %1$s", coins);
        System.out.println();
        System.out.printf("Walls = %1$s", wallHits);
    }

    private static boolean checkIfMoveIsPossible(char[][] map, int row, int col) {
        if(row >= 0 && row < 4
        && col >= 0 && col< map[row].length){
            return true;
        }

        return false;
    }

    private static char[][] fillTheMap(Scanner scan) {
        char[][] matrix = new char[4][0];
        for (int i = 0; i < 4; i++) {
            String mapRow = scan.nextLine();
            char[] currentRow = new char[mapRow.length()];
            currentRow = mapRow.toCharArray();
            matrix[i] = currentRow;
        }
        return matrix;
    }
}

//Input
//Sj0u$hbc
//$87yihc87
//Ewg3444
//$4$$
//V>>^^>>>VVV<<
