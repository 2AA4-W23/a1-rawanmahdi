package pk;
import java.util.ArrayList;

public class Player {

    public int score = 0;  
    
    public int numSkulls = 0;
    
    public ArrayList<Object> rolledFaces;

    public int wins = 0; 
    
    public static void clear(Player player){ // method to reset player attributes/metrics between games
        player.score = 0;
        player.numSkulls = 0;
        player.rolledFaces.clear();
    }

    public float getPercentWins(){ // method to return percentage wins for a player every 42 games
        return wins*100/42;
    }
    
} 