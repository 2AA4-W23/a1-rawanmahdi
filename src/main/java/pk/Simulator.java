package pk;
import java.util.*;

public class Simulator{

    public static void turn(Player player){
        Scanner sc = new Scanner(System.in);
        player.rolledFaces = Dice.rollAll(8); // first roll
        while(true){
            player.score = ScoreCard.goldAndDiamond(player, player.rolledFaces);
            System.out.println("Your total score: "+player.score);
            int len = player.rolledFaces.size();
            for(int i=0; i<len; i++){
                System.out.println(player.rolledFaces.get(i));
                if(player.rolledFaces.get(i) == Faces.SKULL){
                    player.numSkulls++;
                } 
                if(player.numSkulls >=3){  
                break;
                }
            }
            if(player.numSkulls >=3){
                System.out.println("Player 1 rolled 3 skulls! Turn over :(");
                player.rolledFaces.clear();
                break;
            } else {
                while(player.rolledFaces.remove(Faces.SKULL)){}
                System.out.println("You have "+player.rolledFaces.size()+ " dice left:");
                Dice.printFaces(player.rolledFaces);
                System.out.println("Would you like to roll again? Answer yes/no: ");
                String response = (String) sc.next();
                if(response.equals("yes")){
                    player.rolledFaces = Dice.randomRoll(player.rolledFaces);
                } else {
                    System.out.println("terminating Player 1's turn");
                    player.rolledFaces.clear();
                    break;
                }
            }
        }
    }
    
    public static void play(Player p1, Player p2){
        
        //for(int i=1; i<43; i++){
            System.out.println("Player 1's turn");
            turn(p1);
        //}
    }
}