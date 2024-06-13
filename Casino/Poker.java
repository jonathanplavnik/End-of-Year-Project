import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Poker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Poker extends MyWorld
{
    // two player game
    private boolean flopBet = false;
    private boolean flopped = false;
    private boolean turnBet = false;
    private boolean turned = false;
    private boolean washBet = false;
    private boolean washed = false;
    private card[] deck = new cardDeck().deck;
    private int amt1;
    private int amt2;
    private ArrayList<card> hand1 = new ArrayList<>();
    private ArrayList<card> hand2 = new ArrayList<>();
    private int coordinateX;
    private int next = 0;
    private int pot = 0;
    private boolean gameEnded = false;
    
    public Poker (){
        removeButtons();
        
    }
    public void act(){
        showText("Pot: " + pot, 75, 300);
        showText("Player 1: " + amt1, 75, 325);
        showText("Player 2: " + amt2, 75, 350);
        if (!flopped) {
            flop();
            flopped = true;
            flopBet = true;
        } else if (flopBet) {
            FlopBetting();
            if(!gameEnded){
                turn();
                flopBet = false;
                turnBet = true;
            }
        } else if (turnBet) {
            TurnBetting();
            wash();
            turnBet = false;
            washed = true;
        } else if (washed) {
            WashBetting();
            washed = false;
            result();
        }
        
        
    }
    
    // flop, betting, turn, betting, wash, betting
       public void flop(){
        
        
        //deal cards to players and flop
        
        //players
        coordinateX = 180;
        int x1 = 0;
        int x2 = 0;
        for (int i = 0; i < 2; i++){
            card card = deck[i];
            addObject(card, coordinateX, 330);
            card.setImage(card.getImage());
            Greenfoot.delay(4);
            if(i == 0) x1 = coordinateX;
            else x2 = coordinateX;
            coordinateX += 20;
            hand1.add(card);
        }
        addObject(new backCard(), x1, 330);
        addObject(new backCard(), x2, 330);
        
        Greenfoot.delay(15);
        
        coordinateX = 420;
        for (int i = 2; i < 4; i++){
            card card = deck[i];
            addObject(card, coordinateX, 330);
            card.setImage(card.getImage());
            Greenfoot.delay(4);
            if(i == 2) x1 = coordinateX;
            else x2 = coordinateX;
            coordinateX += 20;
            hand2.add(card);
        }
        
        addObject(new backCard(), x1, 330);
        addObject(new backCard(), x2, 330);
        
        // flop (burn a card)
        
        coordinateX = 210;
        for(int i = 5; i < 8; i++){
            card card = deck[i];
            addObject(card, coordinateX, 130);
            card.setImage(card.getImage());
            coordinateX += 30;
            hand1.add(card);
            hand2.add(card);
            
        }
        
        
        
    }
    public void FlopBetting(){
    
    Greenfoot.delay(20);
    
        
    int bet1 = 0; // amount bet by Player 1 in the current round
    int bet2 = 0; // amount bet by Player 2 in the current round
    boolean player1Turn = true;

    while (true) {
        String ans;
        if (player1Turn) {
            ans = Greenfoot.ask("Player 1: call " + bet2 + ", raise, or fold?");
        } else {
            ans = Greenfoot.ask("Player 2: call " + bet1 + ", raise, or fold?");
        }

        try {
            if (ans.equalsIgnoreCase("fold")) {
                if (player1Turn) {
                    endGame("Player 2 Wins!");
                } else {
                    endGame("Player 1 Wins!"); 
                }
                return; // end the betting round
            } else if (ans.equalsIgnoreCase("call")) {
                if (player1Turn) {
                    amt1 += (bet2 - bet1);
                    pot += (bet2 - bet1);
                    bet1 = bet2;
                } else {
                    amt2 += (bet1 - bet2);
                    pot += (bet1 - bet2);
                    bet2 = bet1;
                }
            } else if (ans.toLowerCase().startsWith("raise")) {
                String[] parts = ans.split(" ");
                int raiseAmount = Integer.parseInt(parts[1]);
                if (player1Turn) {
                    amt1 += (bet2 - bet1) + raiseAmount;
                    pot += (bet2 - bet1) + raiseAmount;
                    bet1 = bet2 + raiseAmount;
                } else {
                    amt2 += (bet1 - bet2) + raiseAmount;
                    pot += (bet1 - bet2) + raiseAmount;
                    bet2 = bet1 + raiseAmount;
                }
            } else {
                
                continue; // prompt again without switching turn
            }

            if (bet1 == bet2) {
                break; // exit the loop when both bets are equal
            }

            player1Turn = !player1Turn; // switch turn
        } catch (NumberFormatException e) {
            
        }
    }
    
    bet1 = 0;
    bet2 = 0;
    
    }
    public void turn(){
        
        Greenfoot.delay(10);
        card card = deck[9];
        coordinateX += 30;
        addObject(card, coordinateX, 130);
        hand1.add(card);
        hand2.add(card);
    }
    public void TurnBetting(){
    
    Greenfoot.delay(20);
    
        
    int bet1 = 0; // amount bet by Player 1 in the current round
    int bet2 = 0; // amount bet by Player 2 in the current round
    boolean player1Turn = true;

    while (true) {
        String ans;
        if (player1Turn) {
            ans = Greenfoot.ask("Player 1: call " + bet2 + ", raise, or fold?");
        } else {
            ans = Greenfoot.ask("Player 2: call " + bet1 + ", raise, or fold?");
        }

        try {
            if (ans.equalsIgnoreCase("fold")) {
                if (player1Turn) {
                    endGame("Player 2 Wins!");
                } else {
                    endGame("Player 1 Wins!"); 
                }
                return; // end the betting round
            } else if (ans.equalsIgnoreCase("call")) {
                if (player1Turn) {
                    amt1 += (bet2 - bet1);
                    pot += (bet2 - bet1);
                    bet1 = bet2;
                } else {
                    amt2 += (bet1 - bet2);
                    pot += (bet1 - bet2);
                    bet2 = bet1;
                }
            } else if (ans.toLowerCase().startsWith("raise")) {
                String[] parts = ans.split(" ");
                int raiseAmount = Integer.parseInt(parts[1]);
                if (player1Turn) {
                    amt1 += (bet2 - bet1) + raiseAmount;
                    pot += (bet2 - bet1) + raiseAmount;
                    bet1 = bet2 + raiseAmount;
                } else {
                    amt2 += (bet1 - bet2) + raiseAmount;
                    pot += (bet1 - bet2) + raiseAmount;
                    bet2 = bet1 + raiseAmount;
                }
            } else {
                
                continue; // prompt again without switching turn
            }

            if (bet1 == bet2) {
                break; // exit the loop when both bets are equal
            }

            player1Turn = !player1Turn; // switch turn
        } catch (NumberFormatException e) {
            
        }
    }
    bet1 = 0;
    bet2 = 0;
    }
    public void wash(){
        
        Greenfoot.delay(10);
        card card = deck[11];
        coordinateX += 30;
        addObject(card, coordinateX, 130);
        hand1.add(card);
        hand2.add(card);
    }
    public void WashBetting(){
    
    Greenfoot.delay(20);
    
        
    int bet1 = 0; // amount bet by Player 1 in the current round
    int bet2 = 0; // amount bet by Player 2 in the current round
    boolean player1Turn = true;

    while (true) {
        String ans;
        if (player1Turn) {
            ans = Greenfoot.ask("Player 1: call " + bet2 + ", raise, or fold?");
        } else {
            ans = Greenfoot.ask("Player 2: call " + bet1 + ", raise, or fold?");
        }

        try {
            if (ans.equalsIgnoreCase("fold")) {
                if (player1Turn) {
                    endGame("Player 2 Wins!");
                } else {
                    endGame("Player 1 Wins!"); 
                }
                return;
                
                //return; // end the betting round
            } else if (ans.equalsIgnoreCase("call")) {
                if (player1Turn) {
                    amt1 += (bet2 - bet1);
                    pot += (bet2 - bet1);
                    bet1 = bet2;
                } else {
                    amt2 += (bet1 - bet2);
                    pot += (bet1 - bet2);
                    bet2 = bet1;
                }
            } else if (ans.toLowerCase().startsWith("raise")) {
                String[] parts = ans.split(" ");
                int raiseAmount = Integer.parseInt(parts[1]);
                if (player1Turn) {
                    amt1 += (bet2 - bet1) + raiseAmount;
                    pot += (bet2 - bet1) + raiseAmount;
                    bet1 = bet2 + raiseAmount;
                } else {
                    amt2 += (bet1 - bet2) + raiseAmount;
                    pot += (bet1 - bet2) + raiseAmount;
                    bet2 = bet1 + raiseAmount;
                }
            } else {
                
                continue; // prompt again without switching turn
            }

            if (bet1 == bet2) {
                break; // exit the loop when both bets are equal
            }

            player1Turn = !player1Turn; // switch turn
        } catch (NumberFormatException e) {
            
        }
    }
    bet1 = 0;
    bet2 = 0;
    }
    public void result(){
        Greenfoot.delay(20);
        String result = determineWinner(hand1, hand2);
        showText(result, 300, 200);
        
        removeObjects(getObjects(backCard.class));
    }
    public void endGame(String str){
        flopBet = false;
        flopped = true;
        turnBet = false;
        washBet = false;
        washed = false;
        turned = false;
        gameEnded = true;
        showText(str, 300, 200);
        removeObjects(getObjects(backCard.class));
    }
    
    
    
    
    
    // evaluate winner
    public static int evaluateHand(List<card> hand) {
        if (hand.size() != 7) {
            throw new IllegalArgumentException("Hand must contain exactly 7 cards.");
        }
        
        Collections.sort(hand, Comparator.comparingInt(card::getValue));
        boolean isFlush = isFlush(hand);
        boolean isStraight = isStraight(hand);
        
        if (isFlush && isStraight && hand.get(4).getValue() == 14) {
            return 9; // Royal Flush
        }
        if (isFlush && isStraight) {
            return 8; // Straight Flush
        }
        if (hasFourOfAKind(hand)) {
            return 7; // Four of a Kind
        }
        if (hasFullHouse(hand)) {
            return 6; // Full House
        }
        if (isFlush) {
            return 5; // Flush
        }
        if (isStraight) {
            return 4; // Straight
        }
        if (hasThreeOfAKind(hand)) {
            return 3; // Three of a Kind
        }
        if (hasTwoPair(hand)) {
            return 2; // Two Pair
        }
        if (hasPair(hand)) {
            return 1; // One Pair
        }
        return 0; // High Card
    }
    private static boolean isFlush(List<card> hand) {
        Map<String, Integer> suitCount = new HashMap<>();
        for (card card : hand) {
            suitCount.put(card.getHouse(), suitCount.getOrDefault(card.getHouse(), 0) + 1);
        }
        return suitCount.values().stream().anyMatch(count -> count >= 5);
    }

    private static boolean isStraight(List<card> hand) {
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getValue() + 1 != hand.get(i + 1).getValue()) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasFourOfAKind(List<card> hand) {
        Map<Integer, Integer> valueCount = new HashMap<>();
        for (card card : hand) {
            valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        }
        return valueCount.containsValue(4);
    }

    private static boolean hasFullHouse(List<card> hand) {
        Map<Integer, Integer> valueCount = new HashMap<>();
        for (card card : hand) {
            valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        }
        return valueCount.containsValue(3) && valueCount.containsValue(2);
    }

    private static boolean hasThreeOfAKind(List<card> hand) {
        Map<Integer, Integer> valueCount = new HashMap<>();
        for (card card : hand) {
            valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        }
        return valueCount.containsValue(3);
    }

    private static boolean hasTwoPair(List<card> hand) {
        Map<Integer, Integer> valueCount = new HashMap<>();
        for (card card : hand) {
            valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        }
        int pairCount = 0;
        for (int count : valueCount.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    private static boolean hasPair(List<card> hand) {
        Map<Integer, Integer> valueCount = new HashMap<>();
        for (card card : hand) {
            valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        }
        return valueCount.containsValue(2);
    }
    
    public static String determineWinner(List<card> player1Cards, List<card> player2Cards) {
        int player1Rank = evaluateHand(player1Cards);
        int player2Rank = evaluateHand(player2Cards);

        if (player1Rank > player2Rank) {
            return "Player 1 wins!";
        } else if (player2Rank > player1Rank) {
            return "Player 2 wins!";
        } else {
            // If the ranks are equal, compare the high cards
            return compareHighCards(player1Cards, player2Cards);
        }
    }

    private static String compareHighCards(List<card> hand1, List<card> hand2) {
        Collections.sort(hand1, (a, b) -> b.getValue() - a.getValue());
        Collections.sort(hand2, (a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < hand1.size(); i++) {
            if (hand1.get(i).getValue() > hand2.get(i).getValue()) {
                return "Player 1 wins!";
            } else if (hand2.get(i).getValue() > hand1.get(i).getValue()) {
                return "Player 2 wins!";
            }
        }
        return "It's a tie!";
    }

    
    
    
    
}
