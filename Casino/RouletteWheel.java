import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RouletteWheel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RouletteWheel extends Actor
{
    private boolean isSpinning = false;
    private int spinDuration = 0;

    public void act() {
        if (isSpinning) {
            if (spinDuration > 0) {
                setRotation(getRotation() + 10);
                spinDuration--;
            } else {
                stopSpinning();
            }
        }
    }

    public void startSpinning() {
        isSpinning = true;
        spinDuration = 50; 
    }

    public void stopSpinning() {
        isSpinning = false;
        int outcome = Greenfoot.getRandomNumber(36) + 1;  
        ((Roulette) getWorld()).displayOutcome(outcome);
        
    }
}
