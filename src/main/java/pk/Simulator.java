package pk;
import java.util.*;
import org.apache.logging.log4j.*;

public class Simulator{

    private static final Logger logger = LogManager.getLogger(Simulator.class);

    public static void turn(Player player){
        player.rolledFaces = Dice.rollAll(8); // first roll, always start with 8 dice
        //System.out.println("You rolled the following: ");
        //Dice.printFaces(player.rolledFaces); 
        while(!(ScoreCard.skulls(player))){ // while we dont have 3 skulls
            player.score = ScoreCard.comboScore(player, player.rolledFaces); // compute score for this roll 
            //System.out.println("Your total score: "+player.score);
            while(player.rolledFaces.remove(Faces.SKULL)){} // remove all skulls from set of dice
            //System.out.println("You have "+player.rolledFaces.size()+ " dice left:");
            //Dice.printFaces(player.rolledFaces);
            if(Strategies.keepRolling(player)){
                player.rolledFaces = Strategies.comboRoll(player.rolledFaces); // continue game by executing random rolling startegy
                logger.trace("Player rerolled using combo strategy");
                //System.out.println("You rolled the following: ");
                //Dice.printFaces(player.rolledFaces); 
            }
            else{
                //System.out.println("You rolled "+player.rolledFaces.size()+" of a kind.");
                logger.trace("Player rolled all of 1 kind");
                break;
            }
            //player.rolledFaces = Strategies.randomRoll(player.rolledFaces);
        }
    }
    
    public static void play(Player p1, Player p2){
        for(int i=0; i<42; i++){ // repeat game 42 times
            //System.out.println("Player 1's turn");
            logger.trace("Executing Player 1's turn");
            turn(p1); // execute first player's turn
            //System.out.println("Player 2's turn");
            logger.trace("Executing Player 2's turn");
            turn(p2); // execute second player's turn
            if(p1.score>p2.score){
                p1.wins++; // count wins
            } else if(p2.score>p1.score){
                p2.wins++; 
            }
            Player.clear(p1); // reset their metrics for new game
            Player.clear(p2);
        }
        logger.trace("42 games played");
    }
}