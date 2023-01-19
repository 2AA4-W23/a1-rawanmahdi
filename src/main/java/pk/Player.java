package pk;
import java.util.ArrayList;

public class Player {

    public int score = 0;  
    
    public int numSkulls = 0;
    
    public ArrayList<Object> rolledFaces;

    //public Object[] rolledFaces;   

    public static void clear(Player player){
        player.score = 0;
        player.numSkulls = 0;
        player.rolledFaces.clear();
    }
    
} 