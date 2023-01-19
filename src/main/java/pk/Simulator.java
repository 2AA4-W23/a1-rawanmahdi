package pk;
import java.util.*;

public class Simulator{
    
    public static void play(Player p1, Player p2){
        Scanner sc = new Scanner(System.in);
        //for(int i=1; i<43; i++){
            System.out.println("Player 1's turn");
            
            while(true){
                p1.rolledFaces = Dice.rollAll(8);
                int len = p1.rolledFaces.size();
                for(int i=0; i<len; i++){
                    System.out.println(p1.rolledFaces.get(i));
                    if(p1.rolledFaces.get(i) == Faces.SKULL){
                        p1.numSkulls++;
                    } 
                    if(p1.numSkulls >=3){
                        break;
                    }
                }
                if(p1.numSkulls >=3){
                    System.out.println("Player 1 rolled 3 skulls! Turn over :(");
                    p1.rolledFaces.clear();
                    break;
                } else {
                    while(p1.rolledFaces.remove(Faces.SKULL)){}
                    System.out.println("You have "+p1.rolledFaces.size()+ " dice left");
                    System.out.println("Would you like to roll again? Answer yes/no: ");
                    String response = (String) sc.next();
                    if(response.equals("yes")){
                        p1.rolledFaces = Dice.randomRoll(p1.rolledFaces);
                    } else {
                        System.out.println("terminating Player 1's turn");
                        p1.rolledFaces.clear();
                        break;
                    }
                }
            }
        //}
    }
}