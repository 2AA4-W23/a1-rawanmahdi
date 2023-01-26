package pk;
import java.util.*;
import org.apache.logging.log4j.*;

public class Simulator{

    private static final Logger logger = LogManager.getLogger(Simulator.class);

    public static void turn(Player player, String strategy, ArrayList<Object> card){
    
        player.rolledFaces = Dice.rollAll(8); // first roll, always start with 8 dice
        int count = 0;
        // System.out.println("Card drawn: "+ card.get(0) + " with num: "+ card.get(1));
        while(!(ScoreCard.skulls(player))){ // while we dont have 3 skulls
            ScoreCard.computeScore(player);
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
            ArrayList<ArrayList<Object>> deck = CardDeck.makePile(); // refresh the deck  
            logger.trace("Executing Player 1's turn");
            ArrayList<Object> drawnCard1 = CardDeck.draw(deck);
            turn(p1, strategy1, drawnCard1); // execute first player's turn
            logger.trace("Executing Player 2's turn");
            ArrayList<Object> drawnCard2 = CardDeck.draw(deck);
            turn(p2, startegy2, drawnCard2); // execute second player's turn
            System.out.println("Player 1 score: "+ p1.score);
            System.out.println("Player 2 score: "+ p2.score);
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