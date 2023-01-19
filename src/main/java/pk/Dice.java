package pk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Dice {

    public Faces roll() {
        int howManyFaces = Faces.values().length;
        //System.out.println("  (DEBUG) there are " + howManyFaces + " faces");
        //System.out.println("  (DEBUG) " + Arrays.toString(Faces.values()));
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }

    public static ArrayList<Object> rollAll(int numDice) {
        Dice myDice = new Dice();
        ArrayList<Object> faces = new ArrayList<Object>();
        //Object[] faces = new Object[8];
        for(int i=0; i<=numDice; i++){
            faces.add(myDice.roll());
            //faces[i] = my_Dice.roll();
        }
        return faces;
    }

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
