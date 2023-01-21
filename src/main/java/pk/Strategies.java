package pk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Strategies{

    public static ArrayList<Object> randomRoll(ArrayList<Object> faces){
        //int len = faces.length;
        int len = faces.size();
        Random rand = new Random();
        int reroll = rand.nextInt(len+1); // reroll 0-len dice 
        Dice dice = new Dice();
        Collections.shuffle(faces); // randomize order

        for(int i=0; i<reroll; i++){
            //List<Object> facesList = Arrays.asList(faces);
            //facesList.toArray(faces);
            faces.set(i, dice.roll()); // replace first element
        }
        return faces;
    }
}