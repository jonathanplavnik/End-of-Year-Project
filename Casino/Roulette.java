import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Roulette here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Roulette extends MyWorld
{
    public Roulette (){
        super();
        removeButtons();
        setBackground(new GreenfootImage("Wheel.png"));
        
        setupGameComponents();
    }
    public void setupGameComponents() {
        StartButton startButton = new StartButton();
        addObject(startButton, getWidth() / 2, getHeight() - 50);
    }
}
