import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlotMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlotMachine extends MyWorld
{
    /**
     * Act - do whatever the SlotMachine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    slotChars[] results = new slotChars[3];
    double prob;
    public void act()
    {
        for(int j = 0; j < 20; j++){
            
            for(int i = 0; i <=2; i++){
                prob = (Math.random()* 100);
                if(prob > 97){
                  results[i] = new grand();
                }
                
                else if(prob > 90){
                    results[i] = new lar();
                }
                
                else if(prob > 50){
                    results[i] = new med();
                }
                
                else{
                    results[i] = new small();
                }
            }
            displaySymbols();
        }
    }
    public void displaySymbols(){
        World World =(Slots)getWorld();
        // World.removeChars();
        World.addObject(results[0],199, 208);
        World.addObject(results[1],295, 208); 
        World.addObject(results[2],390, 208); 
        
    }
}
