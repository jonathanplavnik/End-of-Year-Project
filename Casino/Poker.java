import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

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
        // Display the question using JOptionPane
        String question = "How much do you bet?";
        int amt = Integer.parseInt(JOptionPane.showInputDialog(null, question));
        
    }
    public void preflop(){
        cardDeck deck = new cardDeck();
        card a = deck.deck[0][0];
        System.out.println(a.getImage());
    }
}
