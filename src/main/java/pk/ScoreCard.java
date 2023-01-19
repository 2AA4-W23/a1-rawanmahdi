package pk;
import java.util.ArrayList;

public class ScoreCard{
    public static int goldAndDiamond(Player player, ArrayList<Object> faces){
        for(int i=0; i<faces.size(); i++){
            if(faces.get(i)==Faces.GOLD || faces.get(i)==Faces.DIAMOND){
                player.score += 100;
            }
        }
        return player.score;
    }

}