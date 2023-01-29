package pk;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Random;
import org.apache.logging.log4j.*;

public class Strategies{

    private static final Logger logger = LogManager.getLogger(Strategies.class);

    public static boolean keepRolling(Player player, ArrayList<Object> card){
        boolean shouldRoll = true;
        Map<Object,Integer> frequency = ScoreCard.countFaces(player.rolledFaces);
        if(card.get(0)==Cards.SeaBattle){
            int numSabers = frequency.get(Faces.SABER); // if we have Sea Battle card
            if(numSabers >= (int) card.get(1)){
                player.score += (int) card.get(2);
                shouldRoll = false; // stop rolling when we roll the wanted num of sabers
                logger.trace("Player rolled required Saber count for Sea Battle card, terminating turn");
            } 
        } else if(card.get(0) == Cards.MonkeyBuisness) {
            int numMonkeys = frequency.get(Faces.MONKEY);
            int numParrots = frequency.get(Faces.PARROT);
            if(numMonkeys+numParrots == player.rolledFaces.size()){
                shouldRoll = false;
                logger.trace("Player rolled all Monkeys and Parrots for the Monkey Buisness card, terminating turn");
            }
        } else if(card.get(0) == Cards.nop) {
            for(Map.Entry<Object,Integer> entry: frequency.entrySet()){
                Object face = entry.getKey();
                int freq = entry.getValue();
                if(freq == player.rolledFaces.size()){ // if we roll all of a kind, stop rolling
                    shouldRoll = false;
                    logger.trace("Player rolled all of a kind, terminating turn");                        
                    break;
                }
            }
        } 
        return shouldRoll;
    }

    public static void randomRoll(Player player){
        ArrayList<Object> faces = player.rolledFaces;
        int len = faces.size();
        Random rand = new Random();
        int reroll = rand.nextInt(len+1); // reroll 0-len dice 
        Dice dice = new Dice();
        Collections.shuffle(faces); // randomize order
        for(int i=0; i<reroll; i++){
            faces.set(i, dice.roll()); // replace first element
        }
        player.rolledFaces = faces;
    }

    public static void comboRoll(Player player){
        ArrayList<Object> faces =  player.rolledFaces;
        Dice dice = new Dice();
        Map<Object,Integer> frequency = ScoreCard.countFaces(faces); // get frequency map
        Object keepFace = dice.roll(); // init to random face
        int max = 0;
        for(Map.Entry<Object,Integer> entry: frequency.entrySet()){ //iterate over map via entries
            Object face = entry.getKey();
            int freq = entry.getValue();
            if(freq > max){
                keepFace = face;
                max = freq;
            }
        }
        Dice.rerollSpecified(faces, keepFace);
        player.rolledFaces = faces;
    } 

    public static void cardRoll(Player player, ArrayList<Object> card){
        ArrayList<Object> faces = player.rolledFaces;
        Dice dice = new Dice();
        if(card.get(0)==Cards.SeaBattle){
            Dice.rerollSpecified(faces, Faces.SABER);
        }
        if(card.get(0)==Cards.MonkeyBuisness){
            for(int i=0; i<faces.size(); i++){
                if(faces.get(i)!=Faces.MONKEY && faces.get(i)!=Faces.PARROT){
                    faces.set(i, dice.roll()); // roll all dice in set that arent the keep face
                }
            }
        }
        player.rolledFaces = faces;
    }
}