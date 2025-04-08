/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author sepidehpourshirazi
 */
class CardWar extends Card {
    private String suit;
    private int value;
    
    public CardWar(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
