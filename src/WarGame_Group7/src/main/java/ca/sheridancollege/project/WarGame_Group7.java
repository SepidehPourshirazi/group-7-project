/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author sepidehpourshirazi
 */
public class WarGame_Group7 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the War Card Game!");
        System.out.print("Enter Player 1 name: ");
        String player1Name = scanner.nextLine();
        
        System.out.print("Enter Player 2 name: ");
        String player2Name = scanner.nextLine();
        
        WarGame game = new WarGame("War Game", player1Name, player2Name);
        game.play();
    }
}
