import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {    
        super(600, 400, 1); 
        //later make a for loop which makes each button and labels it to add modulatiry to code maybe ButtonMaker() 
        Button button = new Button("homePortal");
        addObject(button,568,364);
        
        Button1 button1 = new Button1("slotPortal");
        addObject(button1,568,200);
        
        Button2 button2 = new Button2("roulettePortal");
        addObject(button2,25,190);
        
        Button3 button3 = new Button3("pokerPortal");
        addObject(button3,235,195);
        
        Button4 button4 = new Button4("bjPortal");
        addObject(button4,450,197);
        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
    }
    public void removeButtons(){
        removeObjects(getObjects(Button1.class));
        removeObjects(getObjects(Button2.class));
        removeObjects(getObjects(Button3.class));
        removeObjects(getObjects(Button4.class));
    }
}
