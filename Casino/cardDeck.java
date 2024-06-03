import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cardDeck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cardDeck extends Actor
{
    /**
     * Act - do whatever the cardDeck wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int[] values = new int[52];
    private String[] house = new String[52];
    private card[][] deck = new card[52][2];
    public void act()
    {
        // Add your action code here.
    }
    public void assignValsHouse(){
        int val = 2;
        for (int i = 0; i < 13; i ++){
            values[i] = val;
            val ++;
            house[i] = "heart";
        }
        val = 2;
        for (int i = 13; i < 26; i ++){
            values[i] = val;
            val ++;
            house[i] = "spade";
        }
        val = 2;
        for (int i = 26; i < 39; i ++){
            values[i] = val;
            val ++;
            house[i] = "diamond";
        }
        val = 2;
        for (int i = 39; i < 52; i ++){
            values[i] = val;
            val ++;
            house[i] = "club";
        }
    }
    
    public card[] createDeck(){
        String appearance;
        for (int i = 0; i < 52; i ++){
            appearance = values[i] + house[i];
            GreenfootImage face = new GreenfootImage(appearance);
            deck[i][0] = new card (values[i],house[i], face); 
            deck[i][1] = new card (values[i],house[i], ); 
        }
        return deck;
    }
}
