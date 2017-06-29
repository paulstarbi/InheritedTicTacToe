package com.wojnar;

import java.util.Scanner;

/**
 * Created by bartomiej on 27.06.17.
 */
public class TicTacToeMain {
    public static void main(String[] args) {
        System.out.println("Which character goes first (X or O)");
        String secondCharacter;
        Scanner sc = new Scanner(System.in);
        String firstCharacter = sc.next();
        if (firstCharacter.equals("O")) {
            secondCharacter = "X";
        } else {
            secondCharacter = "O";
        }

        String[][] board = {{" "," "," "},{" "," "," "},{" "," "," "}};

        printBoard(board);
        for (int i = 0 ; i < 9 ; i++) {
            int x, y;
            boolean playerPlacedCharacter = false;
            while (!playerPlacedCharacter) {
                System.out.println("Where would player with " + firstCharacter + " like to place his character");
                System.out.println("Choose X coordinate (number from 1 - 3)");
                x = sc.nextInt() - 1;
                System.out.println("Choose Y coordinate (number from 1 - 3)");
                y = sc.nextInt() - 1;
                if (board[y][x].equals(" ")) {
                    board[y][x] = firstCharacter;
                    playerPlacedCharacter = true;
                } else {
                    System.out.println("Wrong coordinates, try again");
                }
            }

            printBoard(board);
            if (checkIfWin(firstCharacter, board)) {
                System.out.println("Player with character " + firstCharacter + " won!");
                break;
            }

            playerPlacedCharacter = false;
            while (!playerPlacedCharacter) {
                System.out.println("Where would player with " + secondCharacter + " like to place his character");
                System.out.println("Choose X coordinate (number from 1 - 3)");
                x = sc.nextInt() - 1;
                System.out.println("Choose Y coordinate (number from 1 - 3)");
                y = sc.nextInt() - 1;
                if (board[y][x].equals(" ")) {
                    board[y][x] = secondCharacter;
                    playerPlacedCharacter = true;
                } else {
                    System.out.println("Wrong coordinates, try again");
                }
            }

            printBoard(board);
            if (checkIfWin(secondCharacter, board)) {
                System.out.println("Player with character " + secondCharacter + " won!");
                break;
            }
        }

    }

    static boolean checkIfWin (String character, String[][] board) {
        //check row
        for (int i = 0 ; i < 3 ; i++) {
            if (board[i][0].equals(character) && board[i][1].equals(character) && board[i][2].equals(character) ) return true;
        }

        //check columns
        for (int i = 0 ; i < 3 ; i++) {
            if (board[0][i].equals(character) && board[1][i].equals(character) && board[2][i].equals(character) ) return true;
        }

        //check first diagonal
        if (board[0][0].equals(character) && board[1][1].equals(character) && board[2][2].equals(character)) return true;

        //check second diagonal
        if (board[0][2].equals(character) && board[1][1].equals(character) && board[2][0].equals(character)) return true;

        return false;
    }

    static void printBoard(String[][] board) {
        for(int i = 0; i < board.length; i++) {
            String line = "";
            for(int j = 0; j < board[i].length; j++) {
                line += board[i][j] + " | ";
            }
            System.out.println(line.substring(0, line.length() - 3));
        }
    }
}
