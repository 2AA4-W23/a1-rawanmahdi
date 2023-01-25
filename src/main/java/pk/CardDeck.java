package pk;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Queue;

public class CardDeck {

    //public ArrayList<Object> pile; // turn this into a queue
    public static ArrayList<Object> makePile(){
        ArrayList<Object> pile = new ArrayList<Object>();
        for(int i=0; i<6; i++){
            pile.add(Cards.SeaBattle);
        }
        for(int i=0; i<29; i++){
            pile.add(Cards.nop);
        }
        Collections.shuffle(pile);
        return pile;
    }

    public static Object draw(ArrayList<Object> pile){
        Object drawnCard = pile.get(0);
        pile.remove(0); 
        return drawnCard;
    }
} 