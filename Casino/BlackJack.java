import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class blackjack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackJack extends MyWorld
{
    public BlackJack (){
        removeButtons();
    }
    
    public  ArrayList<card> player = new ArrayList<>();
    public ArrayList<card> dealer = new ArrayList<>();
    public int sumPlayer;
    public int sumDealer;
    boolean isPlayerTurn = true;
    cardDeck pile = new cardDeck();
    /**
     * Act - do whatever the blackjack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void fill(){
        dealer.add(pile.deck[0][1]);
        dealer.add(pile.deck[1][0]);
        player.add(pile.deck[2][0]);
        player.add(pile.deck[3][0]);
    }
    public void reset(){
        pile.deck.remove(0);
        pile.deck.remove(1);
        pile.deck.remove(2);
        pile.deck.remove(3);
        
        player.get(1)
        player.clear();
        dealer.clear();
        
    }
    public void act(){
        if (isPlayerTurn && Greenfoot.isKeyDown("s")){
            int sumPlay = (player.get(0)).getValue()+ (player.get(1)).getValue();
            int sumDealer = (dealer.get(0)).getValue()+ (dealer.get(1)).getValue();
            if (sumPlay > sumDealer){
                showText("You win", 300,200);
            }
            else{
                showText("You lose", 300,200);
            }
            fill();
        }

    }
}
