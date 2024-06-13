import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    public Poker (){
        removeButtons();
        System.out.println("test1");
        //preflop();
        
        flop();
        FlopBetting();
        turn();
        TurnBetting();
        wash();
        washBetting();
        
    }
    public void act(){
        if(questionAsked){
            System.out.println("test2");
            displayQuestion();
            questionAsked = false;
        }
        
    }
    public void displayQuestion() {
        System.out.println("test3");
        int amt1 = Integer.parseInt(Greenfoot.ask("This is a two player game! How much does Player 1 bet?"));
        System.out.println("test4");
        int amt2 = Integer.parseInt(Greenfoot.ask("How much does Player 2 bet?"));
        System.out.println("test5");
    }
    public void preflop(){
        cardDeck deck = new cardDeck();
        card a = deck.deck[0];
        System.out.println(a.getImage());
    }
    
    // Pre flop + deal, flop, betting, turn, betting, wash, betting
    public void flop(){
        
    }
    public void FlopBetting(){
        
    }
    public void turn(){
        
    }
    public void TurnBetting(){
        
    }
    public void wash(){
        
    }
    public void washBetting(){
        
    }
    
}
