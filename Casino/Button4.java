import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button4 extends Actor
{
    /**
     * Act - do whatever the Button4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String name;
    public Button4(String name){
       this.name = name; 
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Poker());
        }
    }
}
