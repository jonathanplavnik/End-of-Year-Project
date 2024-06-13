import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Roulette here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Roulette extends MyWorld
{
    private RouletteWheel wheel;
    private int playerGuess = -1;
    public Roulette (){
        super();
        removeButtons();
        
        wheel = new RouletteWheel();
        addObject(wheel, getWidth() / 2, getHeight() / 2);
        
        prepareForNextRound();
    }
    public void prepareForNextRound() {
        StartButton startButton = new StartButton();
        addObject(startButton, getWidth() - 550, 50);
    }
    
    public void setPlayerGuess(int guess) {
        this.playerGuess = guess;  // Store the player's guess
    }

    public void displayOutcome(int outcome) {
        String message;
        if (outcome == playerGuess) {
            message = "Congratulations! You won! The ball landed on: " + outcome;
        } else {
            message = "Sorry, you lost. The ball landed on: " + outcome;
        }
        showText(message, getWidth() / 2, getHeight() / 2);  
        Greenfoot.delay(200);  
        showText("", getWidth() / 2, getHeight() / 2);  
        prepareForNextRound();  
    }
    
    
    
    
}
