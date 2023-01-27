package pk;
import java.util.ArrayList;
import java.util.Random;

public class Dice {

    public Faces roll() {
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }

    public static ArrayList<Object> rollAll(int numDice) {
        Dice myDice = new Dice();
        ArrayList<Object> faces = new ArrayList<Object>();
        for(int i=0; i<numDice; i++){
            faces.add(myDice.roll()); // roll dice for each index of list
        }
        return faces;
    }

    public static ArrayList<Object> rerollSpecified(ArrayList<Object> faces, Object keepFace){
        Dice dice = new Dice();
        for(int i=0; i<faces.size(); i++){
            if(faces.get(i)!=keepFace){
                faces.set(i, dice.roll()); // roll all dice in set that arent the keep face
            }
        }
        return faces;
    }
    
    public static void printFaces(ArrayList<Object> faces){ //method to streamline printing the faces - for debugging
        for(int i=0; i<faces.size(); i++){
            System.out.println(faces.get(i));
        }
    }
}
