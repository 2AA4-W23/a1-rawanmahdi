package pk;
import java.util.ArrayList;

public class ScoreCard{

    public static int goldAndDiamond(Player player, ArrayList<Object> faces){ // method to compute score based on number of gold coins and diamonds rolled
        for(int i=0; i<faces.size(); i++){
            if(faces.get(i)==Faces.GOLD || faces.get(i)==Faces.DIAMOND){
                player.score += 100;
            }
        }
        return player.score;
    }

    public static boolean skulls(Player player){ // method to check if game should continue based on how many skulls a player has rolled
        int len = player.rolledFaces.size();
        boolean threeSkulls = false;
        for(int i=0; i<len; i++){
            if(player.rolledFaces.get(i) == Faces.SKULL){
                player.numSkulls++;
            } 
            if(player.numSkulls >=3){  
                threeSkulls =  true;
                System.out.println("Player rolled 3 skulls! Turn over :(");
                break;
            }
        }
        return threeSkulls;
    }

    

}