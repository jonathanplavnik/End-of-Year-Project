import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class chip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class chip extends Actor
{
    /**
     * Act - do whatever the chip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int value;
    private int amt;
    public chip(int value, int amt){
        this.value = value;
        this.amt = amt;
    }
    public int getValue(){
        return value;
    }
    public int getAmt(){
        return amt;
    }
    public void setAmt(int newAmt){
       amt = newAmt;
    }
    public void act()
    {
        // Add your action code here.
    }
}
