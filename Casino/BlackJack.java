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

    public static int playerSum;

    public static int dealerSum;

    public int hits = 0;

    Hit butHit = new Hit();

    stand butStand = new stand();

    public BlackJack (){

        removeButtons();

        fill();

        showCards();

        for (int i = 0; i < player.size(); i ++){

            if (player.get(i).getValue() == 14){

                if(playerSum + 11 > 21){

                    player.get(i).setValue(1);

                }

                else{

                    player.get(i).setValue(11);

                }

            }

            else if (player.get(i).getValue() > 10){

                player.get(i).setValue(10);

            }   

            playerSum += player.get(i).getValue();

        }

        for (int j = 0; j < dealer.size(); j ++){

            if (dealer.get(j).getValue() == 14){

                if(dealerSum + 11 > 21){

                    dealer.get(j).setValue(1);

                }

                else{

                    dealer.get(j).setValue(11);

                }

            }

            else if (dealer.get(j).getValue() > 10){

                dealer.get(j).setValue(10);

            }   

            dealerSum += dealer.get(j).getValue();

        }

        addObject(butHit, 400, 200);

        addObject(butStand, 200, 200);

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

            addObject(card,  coordinateX, 330);

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

        if(isPlayerTurn && Greenfoot.mouseClicked(butHit)){

            hits += 1;

            card top = pile.deck[dealer.size() + player.size()];

            if (top.getValue() == 14){

                if(playerSum + 11 > 21){

                    top.setValue(1);

                }

                else{

                    top.setValue(11);

                }

            }

            else if (top.getValue() > 10){

                top.setValue(10);

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

                    for (int i = 0; i < player.size(); i ++){

                        if (player.get(i).getValue() == 14){

                            if(playerSum + 11 > 21){

                                player.get(i).setValue(1);

                            }

                            else{

                                player.get(i).setValue(11);

                            }

                        }

                        else if (player.get(i).getValue() > 10){

                            player.get(i).setValue(10);

                        }   

                        playerSum += player.get(i).getValue();

                    }

                    for (int j = 0; j < dealer.size(); j ++){

                        if (dealer.get(j).getValue() == 14){

                            if(dealerSum + 11 > 21){

                                dealer.get(j).setValue(1);

                            }

                            else{

                                dealer.get(j).setValue(11);

                            }

                        }

                        else if (dealer.get(j).getValue() > 10){

                            dealer.get(j).setValue(10);

                        }   

                        dealerSum += dealer.get(j).getValue();

                    }

                    showCards();

                    hits = 0;

                    Greenfoot.delay(2);

                    showText("", 300,200);

                    isPlayerTurn = true;

                }

            }

        }

        else if (Greenfoot.mouseClicked(butStand)){

            isPlayerTurn = false;

            while (dealerSum < playerSum || dealerSum < 21){

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

                showCards();

                hits += 1;

            }

            if (dealerSum > 21){

                showText("You win", 300,200);

                if (pile.deck.length >= 8 + hits){

                    playerSum = 0;

                    dealerSum = 0;

                    Greenfoot.delay(3);

                    reset(hits);

                    removeObjects(getObjects(card.class));

                    fill();

                    for (int i = 0; i < player.size(); i ++){

                        if (player.get(i).getValue() == 14){

                            if(playerSum + 11 > 21){

                                player.get(i).setValue(1);

                            }

                            else{

                                player.get(i).setValue(11);

                            }

                        }

                        else if (player.get(i).getValue() > 10){

                            player.get(i).setValue(10);

                        }   

                        playerSum += player.get(i).getValue();

                    }

                    for (int j = 0; j < dealer.size(); j ++){

                        if (dealer.get(j).getValue() == 14){

                            if(dealerSum + 11 > 21){

                                dealer.get(j).setValue(1);

                            }

                            else{

                                dealer.get(j).setValue(11);

                            }

                        }

                        else if (dealer.get(j).getValue() > 10){

                            dealer.get(j).setValue(10);

                        }   

                        dealerSum += dealer.get(j).getValue();

                    }

                    showCards();

                    hits = 0;

                    Greenfoot.delay(2);

                    showText("", 300,200);

                    isPlayerTurn = true;

                }

            }

            else{

                showText("You lose", 300,200);

                if (pile.deck.length >= 8 + hits){

                    playerSum = 0;

                    dealerSum = 0;

                    Greenfoot.delay(3);

                    reset(hits);

                    removeObjects(getObjects(card.class));

                    fill();

                    for (int i = 0; i < player.size(); i ++){

                        if (player.get(i).getValue() == 14){

                            if(playerSum + 11 > 21){

                                player.get(i).setValue(1);

                            }

                            else{

                                player.get(i).setValue(11);

                            }

                        }

                        else if (player.get(i).getValue() > 10){

                            player.get(i).setValue(10);

                        }   

                        playerSum += player.get(i).getValue();

                    }

                    for (int j = 0; j < dealer.size(); j ++){

                        if (dealer.get(j).getValue() == 14){

                            if(dealerSum + 11 > 21){

                                dealer.get(j).setValue(1);

                            }

                            else{

                                dealer.get(j).setValue(11);

                            }

                        }

                        else if (dealer.get(j).getValue() > 10){

                            dealer.get(j).setValue(10);

                        }   

                        dealerSum += dealer.get(j).getValue();

                    }

                    showCards();

                    hits = 0;

                    Greenfoot.delay(2);

                    showText("", 300,200);

                    isPlayerTurn = true;

                }

            } 

        }

 

    }

}