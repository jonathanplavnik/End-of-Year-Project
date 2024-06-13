import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class turn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class turn extends Actor
{
    /**
     * Act - do whatever the turn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int next = 0;
    public void act()
    {
        // Add your action code here.
        
        if(Greenfoot.mouseClicked(this)){
            next++;
        }
    }
    public int getNext(){
        return this.next;
    }
    public void setNext(int next){
        this.next = next;
    }
}
