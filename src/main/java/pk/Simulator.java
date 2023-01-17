package pk;
import java.util.*;

public class Simulator{
    
    public static void play(Player p1, Player p2){
        //Scanner sc = new Scanner();
        //for(int i=1; i<43; i++){

            System.out.println("Player 1's turn");
            int roll = 8;
            while(true){
                p1.rolledFaces = Dice.rollAll(roll);
                for(int j=0; j<9; j++){
                    System.out.println(p1.rolledFaces[j]);
                    if(p1.rolledFaces[j] == Faces.SKULL){
                        p1.numSkulls++;
                        roll--;
                    } 
                    if(p1.numSkulls >= 3);
                        break; 
                }
                if(p1.numSkulls >=3){
                    System.out.println("Player 1 rolled 3 skulls! Turn over :(");
                    break;
                }
            }
        //}
    }
}