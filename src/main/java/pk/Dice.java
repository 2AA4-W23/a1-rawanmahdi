package pk;
import java.util.Arrays;
import java.util.Random;

public class Dice {

    public Faces roll() {
        int howManyFaces = Faces.values().length;
        //System.out.println("  (DEBUG) there are " + howManyFaces + " faces");
        //System.out.println("  (DEBUG) " + Arrays.toString(Faces.values()));
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }

    public static Object[] rollAll(int numDice) {
        Dice my_Dice = new Dice();
        Object[] faces = new Object[8];
        for(int i=0; i<numDice; i++){
                faces[i] = my_Dice.roll();
        }
        return faces;
    }
}
