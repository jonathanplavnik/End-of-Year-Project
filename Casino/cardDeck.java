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
    
    public card[] deck = new card[52];
    private String[] house = new String[]{"hearts","diamonds", "clubs", "spades"};
    
    public void act()
    {
        // Add your action code here.
    }
    public cardDeck() {
        this.deck = createDeck();
    }
    public card[] createDeck(){
        String appearance;
        GreenfootImage back = new GreenfootImage("backCard.png");
        int index = 0;
        for (int i = 0; i < 4; i ++){
            for (int j = 2; j < 11; j ++){
                appearance = j + "_of_" + house[i] + ".png";
                GreenfootImage face = new GreenfootImage(appearance);
                deck[index] = new card (j,house[i], face, back); 
                index ++;
            }
            deck[index]= new card (11,house[i], new GreenfootImage("jack_of" + house[i] + ".png"), back);
            index ++;
            deck[index] = new card (12,house[i], new GreenfootImage("queen_of" + house[i] + ".png"), back);
            index ++;
            deck[index] = new card (13,house[i], new GreenfootImage("king_of" + house[i] + ".png"), back);
            index ++;
            deck[index]= new card (14,house[i], new GreenfootImage("ace_of" + house[i] + ".png"), back);
            index ++;
        }
        return deck;
    }
    
}
