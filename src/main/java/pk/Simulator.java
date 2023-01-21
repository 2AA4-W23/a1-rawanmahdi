package pk;
import java.util.*;

public class Simulator{

    public static void turn(Player player){
        player.rolledFaces = Dice.rollAll(8); // first roll
        
        while(!(ScoreCard.skulls(player))){ // while we dont have 3 skulls
            System.out.println("You rolled the following: ");
            Dice.printFaces(player.rolledFaces);
            player.score = ScoreCard.goldAndDiamond(player, player.rolledFaces);
            System.out.println("Your total score: "+player.score);
            while(player.rolledFaces.remove(Faces.SKULL)){}
            System.out.println("You have "+player.rolledFaces.size()+ " dice left:");
            Dice.printFaces(player.rolledFaces);
            player.rolledFaces = Strategies.randomRoll(player.rolledFaces);
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
}