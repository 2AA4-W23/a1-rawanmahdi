package pk;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Random;
public class Strategies{

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
        for(int i=0; i<faces.size(); i++){
            if(faces.get(i) != keepFace){ // if the face at index i is not in the set of faces we keep, 
                faces.set(i, dice.roll()); // reroll face at i;
            }
        }
        return faces;

    }
    public static boolean keepRolling(Player player){
        boolean shouldRoll = true;
        Map<Object,Integer> frequency = ScoreCard.countFaces(player.rolledFaces);
        for(Map.Entry<Object,Integer> entryi: frequency.entrySet()){
            Object facei = entryi.getKey();
            int freqi = entryi.getValue();
            if(freqi == player.rolledFaces.size()){
                shouldRoll = false;
                break;
            }
        }
        return shouldRoll;
    }
}