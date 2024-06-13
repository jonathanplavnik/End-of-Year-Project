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
        shuffle(this.deck);
    }
    public card[] createDeck(){
        String appearance;
        GreenfootImage back = new GreenfootImage("backCard.png");
        int index = 0;
        for (int i = 0; i < 4; i ++){
            for (int j = 2; j < 11; j ++){
                appearance = j + "_of_" + house[i] + ".png";
                GreenfootImage face = new GreenfootImage(appearance);
                face.scale(face.getWidth()/6, face.getHeight()/6);
                deck[index] = new card (j,house[i], face, back); 
                index ++;
            }
            GreenfootImage face = new GreenfootImage("jack_of_" + house[i] + ".png");
            face.scale(face.getWidth()/6, face.getHeight()/6);
            deck[index]= new card (11,house[i], face, back);
            index ++;
            
            face = new GreenfootImage("queen_of_" + house[i] + ".png");
            face.scale(face.getWidth()/6, face.getHeight()/6);
            deck[index]= new card (12,house[i], face, back);
            index ++;
            
            face = new GreenfootImage("king_of_" + house[i] + ".png");
            face.scale(face.getWidth()/6, face.getHeight()/6);
            deck[index]= new card (13,house[i], face, back);
            index ++;
            
            face = new GreenfootImage("ace_of_" + house[i] + ".png");
            face.scale(face.getWidth()/6, face.getHeight()/6);
            deck[index]= new card (14,house[i], face, back);
            index ++;
        }
        return deck;
    }
    public void shuffle(card[] a) {
        for(int i = 0; i < a.length-1; i++){
            int j = (int)(Math.random() * (a.length-i) + i);
            card temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
