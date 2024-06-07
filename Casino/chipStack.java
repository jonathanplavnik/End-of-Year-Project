import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class chipStack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class chipStack extends Actor
{
    /**
     * Act - do whatever the chipStack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // if you want to change amt of chips use setAmt();
    chip[] chipStack = new chip[4];
    public chipStack (){
        this.chipStack = createStack();
    }
    public chip[] createStack(){
        chipStack[0] = new chip(5,20);
        chipStack[1] = new chip(10,10);
        chipStack[2] = new chip (25,8);
        chipStack[3] = new chip(100, 6);
        return chipStack;
    }
}
