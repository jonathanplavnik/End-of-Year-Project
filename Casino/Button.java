import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int n1;
    public String name;
    public Button(String name){
       this.name = name; 
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
