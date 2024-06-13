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
    private boolean questionAsked = true;
    private boolean flopBet = true;
    private boolean turnBet = true;
    private boolean washBet = true;
    private cardDeck deck;
    private int amt1;
    private int amt2;
    private ArrayList<card> hand1 = new ArrayList<>();
    private ArrayList<card> hand2 = new ArrayList<>();
    
    public Poker (){
        removeButtons();
        flop();
        turn();
        wash();
        result();
        
    }
    public void act(){
        if(flopBet){
            FlopBetting();
            flopBet = false;
        }
        if(turnBet){
            TurnBetting();
            turnBet = false;
        }
        if(washBet){
             washBetting();
             washBet = false;
        }
        
        
        
    }
    // flop, betting, turn, betting, wash, betting --> skip preflop
    public void flop(){
        deck = new cardDeck();
        card[] deckUsed = deck.deck;
        
        //deal cards to players and flop
        
        
        
        
    }
    public void FlopBetting(){
        amt1 = Integer.parseInt(Greenfoot.ask("This is a two player game! How much does Player 1 bet?"));
        amt2 = Integer.parseInt(Greenfoot.ask("How much does Player 2 bet?"));
    }
    public void turn(){
        
    }
    public void TurnBetting(){
        amt1 += Integer.parseInt(Greenfoot.ask("How much does Player 1 bet?"));
        amt2 += Integer.parseInt(Greenfoot.ask("How much does Player 2 bet?"));
    }
    public void wash(){
        
    }
    public void washBetting(){
        amt1 += Integer.parseInt(Greenfoot.ask("How much does Player 1 bet?"));
        amt2 += Integer.parseInt(Greenfoot.ask("How much does Player 2 bet?"));
        
    }
    public void result(){
        
        
        String result = determineWinner(hand1, hand2);
        showText(result, 300, 200);
        removeObjects(getObjects(card.class));
    }
    
    
    
    
    
    // evaluate winner
    
    
    
    
    public static int evaluateHand(List<card> hand) {
        Collections.sort(hand, (a, b) -> a.getValue() - b.getValue());
        
        boolean isFlush = hand.stream().allMatch(card -> card.getHouse().equals(hand.get(0).getHouse()));
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
