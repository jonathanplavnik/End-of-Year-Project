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

    public void act() {
        if (isSpinning) {
            setRotation(getRotation() + 10);
        }
    }

    public void startSpinning() {
        isSpinning = true;
    }

    public void stopSpinning() {
        isSpinning = false;
        getWorldOfType(Roulette.class).prepareForNextRound();
    }
}
