import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Poker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Poker extends MyWorld
{
    public Poker (){
        removeButtons();
        preflop();
        displayQuestion();
    }
    public void act(){
        
    }
    public void displayQuestion() {
        
        int amt = Integer.parseInt(Greenfoot.ask("How much do you bet?"));
        
    }
    public void preflop(){
        cardDeck deck = new cardDeck();
        card a = deck.deck[0][0];
        System.out.println(a.getImage());
    }
}
