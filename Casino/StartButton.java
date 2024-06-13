import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int playerGuess = getPlayerGuess();  
            startRoulette(playerGuess);  
        }
    }

    private int getPlayerGuess() {
        String input = Greenfoot.ask("Enter your bet number (0-36): ");
        try {
            int guess = Integer.parseInt(input);
            if (guess >= 0 && guess <= 36) {
                return guess;
            } else {
                getWorld().showText("Invalid input. Please enter a number between 0 and 36.", 300, 20);
                return -1;  
            }
        } catch (NumberFormatException e) {
            getWorld().showText("Invalid input. Please enter a valid number.", 300, 20);
            return -1;  
        }
    }

    private void startRoulette(int playerGuess) {
        if (playerGuess != -1 && getWorld() != null) {  
            RouletteWheel wheel = getWorld().getObjects(RouletteWheel.class).get(0);
            if (wheel != null) {
                wheel.startSpinning();
            } else {
                System.out.println("RouletteWheel not found in the world.");  
        }
    }
    }
}
    

