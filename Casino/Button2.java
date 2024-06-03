import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button2 extends Actor
{
    /**
     * Act - do whatever the Button2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String name;
    public Button2(String name){
       this.name = name; 
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Roulette());
        }
    }
}
