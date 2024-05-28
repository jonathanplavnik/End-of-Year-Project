import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlotMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slots extends Actor
{

    /**
     * Constructor for objects of class SlotMachine.
     * 
     */
    public Slots()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        Button1 button1 = new Button1("homePortal");
        addObject(button1,568,364);
        SlotMachine SlotMachine = new SlotMachine();
        addObject(SlotMachine,297,213);
    }
    public void removeChars(){
        removeObjects(getObjects(slotChars.class));
    }
}
