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
    public Roulette (){
        super();
        removeButtons();
        
        wheel = new RouletteWheel();
        addObject(wheel, getWidth() / 2, getHeight() / 2);
        
        prepareForNextRound();
    }
    public void prepareForNextRound() {
        StartButton startButton = new StartButton();
        addObject(startButton, getWidth() / 2, 50);
    }
}
