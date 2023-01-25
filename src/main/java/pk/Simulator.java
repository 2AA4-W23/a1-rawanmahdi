package pk;
import java.util.*;
import org.apache.logging.log4j.*;

public class Simulator{

    private static final Logger logger = LogManager.getLogger(Simulator.class);

    public static void turn(Player player, String strategy){
        player.rolledFaces = Dice.rollAll(8); // first roll, always start with 8 dice
        while(!(ScoreCard.skulls(player))){ // while we dont have 3 skulls
            player.score = ScoreCard.comboScore(player, player.rolledFaces); // compute score for this roll 
            player.score = ScoreCard.goldAndDiamond(player, player.rolledFaces);
            while(player.rolledFaces.remove(Faces.SKULL)){} // remove all skulls from set of dice
            if(Strategies.keepRolling(player)){
                if(strategy.equals("random")){
                    player.rolledFaces = Strategies.randomRoll(player.rolledFaces); // continue game by executing random rolling startegy
                    logger.trace("Player rerolled using random strategy");
                } else if (strategy.equals("combo")){
                    player.rolledFaces = Strategies.comboRoll(player.rolledFaces); // continue game by executing random rolling startegy
                    logger.trace("Player rerolled using combo strategy");
                }
            }
            else{
                logger.trace("Player rolled all of 1 kind");
                break;
            }
        }
    }
    
    public static void play(Player p1, Player p2, String strategy1, String startegy2){
        for(int i=0; i<42; i++){ // repeat game 42 times
            logger.trace("Executing Player 1's turn");
            turn(p1, strategy1); // execute first player's turn
            logger.trace("Executing Player 2's turn");
            turn(p2, startegy2); // execute second player's turn
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