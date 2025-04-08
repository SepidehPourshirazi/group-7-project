/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.ArrayList;


/**
 *
 * @author sepidehpourshirazi
 */
class PlayerWar extends Player {
    private ArrayList<CardWar> hand;
    
    public PlayerWar(String name) {
        super(name);
        hand = new ArrayList<>();
    }
    
    public void addCard(CardWar card) {
        hand.add(card);
    }
    
    public CardWar drawCard() {
        return hand.isEmpty() ? null : hand.remove(0);
    }
    
    public void winRound(CardWar card1, CardWar card2) {
        hand.add(card1);
        hand.add(card2);
    }
    
    public void winWar(ArrayList<CardWar> warPile) {
        hand.addAll(warPile);
    }
    
    public int getCardCount() {
        return hand.size();
    }
    
    public boolean isOutOfCards() {
        return hand.isEmpty();
    }
    
        private int roundsWon = 0;



    public void incrementRoundsWon() {
        roundsWon++;
    }

    public int getRoundsWon() {
        return roundsWon;
    }
    
    @Override
    public void play() {
        // Play logic implemented in WarGame class
    }
}