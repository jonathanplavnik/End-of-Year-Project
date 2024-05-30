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
    boolean go = true;
    int count = 0;
    public SlotMachine (){
        removeButtons();
    }
    public void act()
    {
        if(go){
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
    count ++;
    if(count > 25){
        go = false;
    }
    }
    
    public void removeChars(){
        removeObjects(getObjects(slotChars.class));
    }
    public void displaySymbols(){
        removeChars();
        addObject(results[0],199, 208);
        addObject(results[1],295, 208); 
        addObject(results[2],390, 208); 
        
    }
    
}
