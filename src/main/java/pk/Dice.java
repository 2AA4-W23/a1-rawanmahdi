package pk;
import java.util.ArrayList;
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
        for(int i=0; i<numDice; i++){
            faces.add(myDice.roll());
            //faces[i] = my_Dice.roll();
        }
        return faces;
    }
    public static void printFaces(ArrayList<Object> faces){
        for(int i=0; i<faces.size(); i++){
            System.out.println(faces.get(i));
        }
    }
}
