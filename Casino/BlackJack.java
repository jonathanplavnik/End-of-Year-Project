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
    public ArrayList<card> player = new ArrayList<>();
    public ArrayList<card> dealer = new ArrayList<>();
    boolean isPlayerTurn = true;
    cardDeck pile = new cardDeck();
    public int playerSum;
    public int dealerSum;
    public int hits = 0;
    public BlackJack (){
        removeButtons();
        fill();
        showCards();
        for (int i = 0; i < player.size(); i ++){
                playerSum += player.get(i).getValue();
        }
        for (int i = 0; i < dealer.size(); i ++){
                dealerSum += dealer.get(i).getValue();
            }
    }
    /**
     * Act - do whatever the blackjack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void fill(){
        dealer.add(pile.deck[0]);
        dealer.add(pile.deck[1]);
        player.add(pile.deck[2]);
        player.add(pile.deck[3]);
    }
    public void reset(int numCards){
        pile.deck = Arrays.copyOfRange(pile.deck, 4 + numCards, pile.deck.length);
        player.clear();
        dealer.clear();
    }
    public void showCards(){
        int coordinateX = 270;
        for (int i = 0; i < player.size(); i ++){
            card card = player.get(i);
            addObject(card, coordinateX, 330);
            card.setImage(card.getImage());
            coordinateX += 20;
        }
        coordinateX = 320;
        for (int i = 0; i < dealer.size(); i ++){
            card dealCard = dealer.get(i);
            addObject(dealCard, coordinateX, 30);
            dealCard.setImage(dealCard.getImage());
            coordinateX -= 20;
        }  
        }
    public void act(){        
        if (isPlayerTurn && Greenfoot.isKeyDown("h")){
            hits += 1;
            card top = pile.deck[dealer.size() + player.size()];
            if (top.getValue() > 10){
                top.setValue(10);
            }
            if (top.getValue() == 14){
                if(playerSum + 11 > 21){
                    top.setValue(1);
                }
                else{
                    top.setValue(11);
                }
            }
            playerSum += top.getValue();
            player.add(top);
            showCards();
            if (playerSum > 21){
                showText("You lose", 300,200);
                if (pile.deck.length >= 8 + hits){
                   playerSum = 0;
                   dealerSum = 0;
                   Greenfoot.delay(3);
                   reset(hits);
                   removeObjects(getObjects(card.class));
                   fill();
                   showCards();
                   hits = 0;
                   Greenfoot.delay(2);
                   showText("", 300,200);
                }
            }
        }
        else if (Greenfoot.isKeyDown("s")){
            while (dealerSum < playerSum){
                card topDealer = pile.deck[dealer.size() + player.size()];
                if (topDealer.getValue() == 14){
                    if(dealerSum + 11 > 21){
                        topDealer.setValue(1);
                    }
                    else{
                        topDealer.setValue(11);
                    }
                }
                else if (topDealer.getValue() > 10){
                    topDealer.setValue(10);
                }
                dealerSum += topDealer.getValue();
                dealer.add(topDealer);
                hits += 1;
                showCards();
                
            }
            if (dealerSum > 21 || playerSum > dealerSum || playerSum == 21){
                showText("You win", 300,200);
            }
            else{
                showText("You lose", 300,200);
            }  
            playerSum = 0;
            dealerSum = 0;
            if (pile.deck.length >= 8 + hits){
               Greenfoot.delay(3);
               reset(hits);
               removeObjects(getObjects(card.class));
               fill();
               showCards();
               hits = 0;
               Greenfoot.delay(2);
               showText("", 300,200);
            }
            isPlayerTurn = true;
        }
        }
        }
