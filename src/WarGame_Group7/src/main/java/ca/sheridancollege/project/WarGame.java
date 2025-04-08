
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class WarGame extends Game {

    private GroupOfCards deck;
    private PlayerWar player1;
    private PlayerWar player2;

    public WarGame(String name, String player1Name, String player2Name) {
        super(name);
        deck = new GroupOfCards(52);
        initializeDeck();
        player1 = new PlayerWar(player1Name);
        player2 = new PlayerWar(player2Name);

        setPlayers(new ArrayList<>());
        getPlayers().add(player1);
        getPlayers().add(player2);
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int value = 2; value <= 14; value++) {
                deck.getCards().add(new CardWar(suit, value));
            }
        }
        deck.shuffle();
    }

    public void play() {
        dealCards();
        while (!player1.isOutOfCards() && !player2.isOutOfCards()) {
            playRound();
        }
        declareWinner();
    }

    private void dealCards() {
        ArrayList<Card> cards = deck.getCards();
        for (int i = 0; i < cards.size(); i++) {
            if (i % 2 == 0) {
                player1.addCard((CardWar) cards.get(i));
            } else {
                player2.addCard((CardWar) cards.get(i));
            }
        }
    }

    private void playRound() {
        CardWar card1 = player1.drawCard();
        CardWar card2 = player2.drawCard();

        System.out.println(player1.getName() + " plays " + card1);
        System.out.println(player2.getName() + " plays " + card2);

        if (card1.getValue() > card2.getValue()) {
            player1.winRound(card1, card2);
            player1.incrementRoundsWon(); // track round win
            System.out.println(player1.getName() + " wins this round!");
        } else if (card1.getValue() < card2.getValue()) {
            player2.winRound(card1, card2);
            player2.incrementRoundsWon(); // track round win
            System.out.println(player2.getName() + " wins this round!");
        } else {
            System.out.println("It's a tie! Going to war...");
            handleWar();
        }
    }

    private void handleWar() {
        System.out.println("WAR initiated!");
        if (player1.getCardCount() < 4 || player2.getCardCount() < 4) {
            System.out.println("One of the players does not have enough cards for war. Ending game...");
            return;
        }

        ArrayList<CardWar> warPile = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            warPile.add(player1.drawCard());
            warPile.add(player2.drawCard());
        }

        CardWar warCard1 = player1.drawCard();
        CardWar warCard2 = player2.drawCard();
        warPile.add(warCard1);
        warPile.add(warCard2);

        System.out.println(player1.getName() + " plays " + warCard1 + " in war");
        System.out.println(player2.getName() + " plays " + warCard2 + " in war");

        if (warCard1.getValue() > warCard2.getValue()) {
            player1.winWar(warPile);
            player1.incrementRoundsWon();
            System.out.println(player1.getName() + " wins the war!");
        } else if (warCard1.getValue() < warCard2.getValue()) {
            player2.winWar(warPile);
            player2.incrementRoundsWon();
            System.out.println(player2.getName() + " wins the war!");
        } else {
            System.out.println("Another tie! War continues...");
            handleWar();
        }
    }

    public void declareWinner() {
        System.out.println("\n--- Game Over ---");
        System.out.println("Rounds won by " + player1.getName() + ": " + player1.getRoundsWon());
        System.out.println("Final score (cards): " + player1.getCardCount());

        System.out.println("Rounds won by " + player2.getName() + ": " + player2.getRoundsWon());
        System.out.println("Final score (cards): " + player2.getCardCount());

        if (player1.getCardCount() > player2.getCardCount()) {
            System.out.println("Winner: " + player1.getName());
        } else if (player1.getCardCount() < player2.getCardCount()) {
            System.out.println("Winner: " + player2.getName());
        } else {
            System.out.println("It's a tie!");
        }
    }
}
