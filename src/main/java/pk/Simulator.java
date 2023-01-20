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
                System.out.println("Player rolled 3 skulls! Turn over :(");
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
                    System.out.println("terminating Player's turn");
                    break;
                }
            }
        }
    }
    
    public static void play(Player p1, Player p2){
        
        for(int i=0; i<42; i++){
            System.out.println("Player 1's turn");
            turn(p1);
            System.out.println("Player 2's turn");
            turn(p2);
            if(p1.score>p2.score){
                p1.wins++;
            } else if(p2.score>p1.score){
                p2.wins++;
            }
            Player.clear(p1);
            Player.clear(p2);
        }
        

    }

    public static void displayWins(Player p1, Player p2){
        float p1PercentWins = p1.wins*100/42;
        float p2PercentWins = p2.wins*100/42;
        System.out.println(p1.wins+" "+p2.wins);
        System.out.println("Player 1 scored "+p1PercentWins+ "% of the time.");
        System.out.println("Player 2 scored "+p2PercentWins+ "% of the time.");
    }


}