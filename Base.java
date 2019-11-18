/* AUTHORS:
 *       HIGUERA CONSUEGRA, PAULA
 *       ARNAEZ PEREZ, BORJA
 */

import java.util.Scanner;

public class Base {

    private static void Printer(char[][] m) {
        /*  PRINTS IN CONSOLE THE MATRIX (GAME BOARD)
         */
        int n_row = m.length, n_col = m[0].length;
        //ROW OF NUMBERS AT TOP
        System.out.print(" ");
        for (int i = 0; i < n_row; i++)
            System.out.print(" " + i);
        //MATRIX (BOARD)
        for (int i = 0; i < n_row; i++) {
            System.out.print("\n" + i);
            for (int j = 0; j < n_row; j++)
                System.out.print(" " + m[i][j]);
            System.out.print(" " + i);
        }
        System.out.println();
        //ROW OF NUMBERS AT BOTTOM
        System.out.print(" ");
        for (int i = 0; i < n_row; i++)
            System.out.print(" " + i);
    }

    private static boolean Mtx_Empty(char[][] m) {
        /*
         *   CHECKS IF THE MATRIX IS EMPTY (RETURNS TRUE) OR NOT (FALSE)
         */
        int n_row = m.length, n_col = m[0].length;
        boolean empty = true;
        for (int i = 0; i < n_row; i++) {
            for (int j = 0; j < n_col; j++) {
                if (m[i][j] <= 'Z' && m[i][j] >= 'A')
                    empty = false;
            }
        }
        return empty;
    }

    private static boolean User_Input_Verif(String Input) {
        boolean valid = true;
        if (Input.length() == 4) {
            char p0 = Input.charAt(0), p1 = Input.charAt(1), p2 = Input.charAt(2), p3 = Input.charAt(3);
            p2 = Character.toUpperCase(p2);
            if (p0 > '9' || p1 > '9' || p3 > '9') {
                valid = false;
            } else if (p0 < '0' || p1 < '0' || p3 < '0') {
                valid = false;
            } else if (p2 != 'N' && p2 != 'E' && p2 != 'S' && p2 != 'O') {
                valid = false;
            }
        } else valid = false;
        return valid;
    }

    //public static String Reader(String st){

    //}

    private static void Game(char[][] matrix, String[] Dict) {
        /*
         *   GAME: IS IN CHARGE OF THE GAME ONCE THE DICTIONARY IS SELECTED AND THE MATRIX IS CREATED
         */
        Scanner in = new Scanner(System.in);
        String UserInput;
        boolean matrix_empty, Input_Valid = false;
        do {
            String Word = "";
            Printer(matrix);
            System.out.println("\nEscriba posicion inicial, dirección (N, S, E, O) y longitud de la palabra (Ej : 11E4)");
            UserInput = in.nextLine();
            Input_Valid = User_Input_Verif(UserInput);
            if (!Input_Valid)
                System.out.println("Entrada no valida");
            else
            matrix_empty = Mtx_Empty(matrix);
        } while (!matrix_empty);
        //GAME OVER

    }

    public static void main(String[] args) {
        int n_row = 10, n_col = 10;
        char[][] matrix;
        Scanner in = new Scanner(System.in);
        //DICTIONARIES
        String[] Chosen_Dict;
        String[] Dict_Normal = {"BONIATO", "BOTARATE", "JAVA", "HELADO", "GRIS", "NARANJA", "VERDE", "MACARRONES",
                "UMAMI", "ANGELOTE", "INFORMATICA", "VALLA", "FINN", "JAKE", "ULTIMA"};
        String[] Dict_Test = {"AAA", "AAAAAA", "BBBBBBBBB", "CCCCC", "DDDDD", "EEEEE", "FFFFF", "GGGGG", "HHHHH",
                "IIIII", "JJJJJ"};
        //USER INPUT
        System.out.print("Introduce p o P para Prueba o cualquier otra entrada para Normal: ");
        String selector = in.next();
        System.out.println();
        //MODE SELECTOR
        char pos0 = selector.charAt(0);
        pos0 = Character.toUpperCase(pos0);
        if (selector.length() == 1 && pos0 == 'P')
            Chosen_Dict = Dict_Test;
        else
            Chosen_Dict = Dict_Normal;
        matrix = NuevaMatriz.nuevaMatriz(n_row, n_col, Chosen_Dict);
        Game(matrix, Chosen_Dict);
    }
}