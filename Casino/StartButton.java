import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    private static Scanner scanner = new Scanner(System.in);
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            getWorld().removeObject(this); 
            int playerGuess = getPlayerGuess();
            startRoulette(playerGuess);
        }
    }
    
    private int getPlayerGuess() {
        System.out.print("Enter your bet number (0-36): ");
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid number. Please enter a number between 0 and 36:");
            scanner.next();
        }
        int guess = scanner.nextInt();
        scanner.nextLine();
        return guess;
    }

    private void startRoulette(int playerGuess) {
        RouletteWheel wheel = getWorld().getObjects(RouletteWheel.class).get(0);
        wheel.startSpinning();
        Greenfoot.delay(100);
        wheel.stopSpinning();

        int outcome = Greenfoot.getRandomNumber(37);
        checkWin(outcome, playerGuess);
    }
    
    private void checkWin(int outcome, int guess) {
        if (outcome == guess) {
            System.out.println("Congratulations! You won! The ball landed on: " + outcome);
        } else {
            System.out.println("Sorry, you lost. The ball landed on: " + outcome);
        }
    }
    
}
