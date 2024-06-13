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
    private turn tracker = new turn();
    private int next = 0;
    
    public Poker (){
        removeButtons();
    }
    public void act(){
        showText("Player 1: " + amt1, 75, 325);
        showText("Player 2: " + amt2, 75, 350);
        if (!flopped) {
            flop();
            flopped = true;
            flopBet = true;
        } else if (flopBet) {
            FlopBetting();
            flopBet = false;
            turnBet = true;
        } else if (turnBet) {
            
            TurnBetting();
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
        addObject(tracker, 550, 50);
        //deal cards to players and flop
        
        //players
        coordinateX = 180;
        for (int i = 0; i < 2; i++){
            card card = deck[i];
            addObject(card, coordinateX, 330);
            card.setImage(card.getImage());
            waitForNextClick(1);
            addObject(new backCard(), coordinateX, 330);
            coordinateX += 20;
            hand1.add(card);
        }
        
        coordinateX = 420;
        for (int i = 2; i < 4; i++){
            card card = deck[i];
            addObject(card, coordinateX, 330);
            card.setImage(card.getImage());
            waitForNextClick(2);
            addObject(new backCard(), coordinateX, 330);
            coordinateX += 20;
            hand2.add(card);
        }
        
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
        waitForNextClick(3);
        String ans = Greenfoot.ask("This is a two player game! How much does Player 1 bet?");
        if(ans.equals("fold")){
            endGame("Player 2 Wins!");
            flopped = false;
            turned = false;
            washed = false;
            showText("Player 2 Wins!", 300, 200);
        } else {
            amt1 = Integer.parseInt(ans);
        }
        
        ans = Greenfoot.ask("How much does Player 2 bet?");
        if(ans.equals("fold")){
            flopped = false;
            turned = false;
            washed = false;
            showText("Player 1 Wins!", 300, 200);
        } else {
            amt2 = Integer.parseInt(ans);
        }
    }
    public void turn(){
        waitForNextClick(4);
        card card = deck[9];
        coordinateX += 30;
        addObject(card, coordinateX, 130);
        
    }
    public void TurnBetting(){
        waitForNextClick(5);
        String ans = Greenfoot.ask("How much does Player 1 bet?");
        if(ans.equals("fold")){
            flopped = false;
            turned = false;
            washed = false;
            showText("Player 2 Wins!", 300, 200);
        } else {
            amt1 += Integer.parseInt(ans);
        }
        
        ans = Greenfoot.ask("How much does Player 2 bet?");
        if(ans.equals("fold")){
            flopped = false;
            turned = false;
            washed = false;
            showText("Player 1 Wins!", 300, 200);
        } else {
            amt2 += Integer.parseInt(ans);
        }
    }
    public void wash(){
        waitForNextClick(6);
        card card = deck[11];
        coordinateX += 30;
        addObject(card, coordinateX, 130);
        
    }
    public void WashBetting(){
        waitForNextClick(7);
        String ans = Greenfoot.ask("How much does Player 1 bet?");
        if(ans.equals("fold")){
            flopped = false;
            turned = false;
            washed = false;
            showText("Player 2 Wins!", 300, 200);
        } else {
            amt1 += Integer.parseInt(ans);
        }
        
        ans = Greenfoot.ask("How much does Player 2 bet?");
        if(ans.equals("fold")){
            flopped = false;
            turned = false;
            washed = false;
            showText("Player 1 Wins!", 300, 200);
        } else {
            amt2 += Integer.parseInt(ans);
        }
        
    }
    public void result(){
        waitForNextClick(8);
        String result = determineWinner(hand1, hand2);
        showText(result, 300, 200);
        
        removeObjects(getObjects(card.class));
    }
    public void endGame(String str){
        flopped = false;
        turned = false;
        washed = false;
        showText(str, 300, 200);
    }
    private void waitForNextClick(int targetNext) {
        while (next != targetNext) {
            next = tracker.getNext();
            Greenfoot.delay(100); // Add a small delay to avoid busy waiting
        }
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
