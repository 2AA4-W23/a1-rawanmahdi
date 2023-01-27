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
        
    

    public static ArrayList<Object> randomRoll(ArrayList<Object> faces){
        int len = faces.size();
        Random rand = new Random();
        int reroll = rand.nextInt(len+1); // reroll 0-len dice 
        Dice dice = new Dice();
        Collections.shuffle(faces); // randomize order

        for(int i=0; i<reroll; i++){
            faces.set(i, dice.roll()); // replace first element
        }
        return faces;
    }

    public static ArrayList<Object> comboRoll(ArrayList<Object> faces){
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
        /*for(int i=0; i<faces.size(); i++){
            if(faces.get(i) != keepFace){ // if the face at index i is not in the set of faces we keep, 
                faces.set(i, dice.roll()); // reroll face at i;
            }
        }*/
        return faces;
    }

    public static void cardRoll(Player player, ArrayList<Object> card){
        ArrayList<Object> faces = player.rolledFaces;
        Dice dice = new Dice();
        if(card.get(0)==Cards.SeaBattle){
            Dice.rerollSpecified(faces, Faces.SABER);
        }
        player.rolledFaces = faces;
    }
}