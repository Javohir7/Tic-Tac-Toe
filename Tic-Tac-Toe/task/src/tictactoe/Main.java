
package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char array[][] = new char[3][3];
        char arr[] = {'X', 'O'}, k = 1;
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0 || j == 4) {
                    System.out.print("| ");
                } else {
                    array[i][j - 1] = ' ';
                    System.out.print("  ");
                }
            }
            System.out.println();

        }
        int total_count = 0;
        System.out.println("---------");
        do {

            System.out.print("Enter the coordinates: ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (0 < x && (x >= 4 || y >= 4)) System.out.println("Coordinates should be from 1 to 3!");
            else if (array[x - 1][y - 1] != ' ') System.out.println("This cell is occupied! Choose another one!");
            else if (!isNumeric(String.valueOf(x)) || !isNumeric(String.valueOf(y)))
                System.out.println("You should enter numbers!");
            else if (array[x - 1][y - 1] == ' ') {
                k++;
                if (k == 2) k = 0;
                array[x - 1][y - 1] = arr[k];
                print(array);
                total_count++;
            }

            if (total_count == 9 && !isWin(array, arr[k])) {
                System.out.println("Draw");
                break;
            }
        } while (!isWin(array, arr[k]));
        if (k == 0) System.out.println("X wins");
        else if (k == 1) System.out.println("O wins");
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void print(char array[][]) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0 || j == 4) {
                    System.out.print("| ");
                } else {
                    if (array[i][j - 1] == '_')
                        System.out.print("  ");

                    else
                        System.out.print(array[i][j - 1] + " ");

                }
            }
            System.out.println();

        }
        System.out.println("---------");
    }

    public static boolean isWin(char[][] array, char sign) {
        int z1Count = 0, z2Count = 0;
        for (int i = 0; i < 3; i++) {
            int signCount = 0;
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == sign) signCount++;
                if (i == j && array[i][j] == sign) z1Count++;
                if (i + j == 2 && array[i][j] == sign) z2Count++;
            }
            if (signCount == 3) return true;
            signCount = 0;
            for (int k = 0; k < 3; k++) {
                if (array[k][i] == sign) signCount++;
            }
            if (signCount == 3) return true;

        }
        if (z1Count == 3 || z2Count == 3) return true;
        return false;
    }
}

