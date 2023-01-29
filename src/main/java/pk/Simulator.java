package pk;
import java.util.*;
import org.apache.logging.log4j.*;

public class Simulator{

    private static final Logger logger = LogManager.getLogger(Simulator.class);

    public static void turn(Player player, String strategy, ArrayList<Object> card){

        player.rolledFaces = Dice.rollAll(8); // first roll, always start with 8 dice
        logger.trace("Card drawn: "+ card.get(0) + " with num: "+ card.get(1));
        
        while(true){ // loop break conditions that end turn 
            logger.trace("Rolled faces: ");
            for(int i=0; i<player.rolledFaces.size(); i++){
                logger.trace("face: "+player.rolledFaces.get(i));
            }

            // deal with skulls in set: 
            if(ScoreCard.threeSkulls(player)){ break; }
            while(player.rolledFaces.remove(Faces.SKULL)){} // remove all skulls from set of dice
            
            // calculate score from last roll according to combos and gold coins/diamonds
            ScoreCard.computeScore(player,card); 
            logger.trace("Player score: "+ player.score);

            // should we keep rolling?
            if(Strategies.keepRolling(player, card)){
                if(strategy.equals("combo")){
                    if(card.get(0) !=  Cards.nop){ // if player drew good card
                        Strategies.cardRoll(player, card); // roll using a card strategy
                        logger.trace("Player rolled with card oriented strategy");                    
                    }
                    else{ // if the player chooses card but draws nop, choose
                        Strategies.comboRoll(player); // continue game by executing random rolling startegy
                        logger.trace("Player rerolled using combo strategy");
                    }
                } else if(strategy.equals("random")){
                        Strategies.randomRoll(player); // continue game by executing random rolling startegy
                        logger.trace("Player rerolled using random strategy");
                }
            }else{
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
            logger.trace("Player 1 total score: "+ p1.score);
            logger.trace("Player 2 total score: "+ p2.score);
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