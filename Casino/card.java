import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class card extends Actor
{
    /**
     * Act - do whatever the card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int value;
    private String house;
    private GreenfootImage image;
    
    public card(int value, String House, GreenfootImage image){
        this.value = value;
        this.image = image;
        this.image = image;
    }
    public int getValue(){
        return this.value;
    }
    public String getHouse(){
        return this.house;
    }
    public GreenfootImage getImage(){
        return this.image;
    }
    public void act()
    {
        // Add your action code here.
    }
    
}
