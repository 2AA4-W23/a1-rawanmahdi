package pk;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;


public class CardDeck {
    
    //public ArrayList<Object> pile; // turn this into a queue
    public static ArrayList<ArrayList<Object>> makePile(){
        ArrayList<ArrayList<Object>> pile = new ArrayList<ArrayList<Object>>();
    
        for(int i=0; i<2; i++){ // add 
            ArrayList<Object> card = new ArrayList<Object>(); 
            card.add(Cards.SeaBattle);
            card.add(2);
            card.add(300);
            pile.add(card);
        }
        for(int i=0; i<2; i++){ // add 
            ArrayList<Object> card = new ArrayList<Object>(); 
            card.add(Cards.SeaBattle);
            card.add(3);
            card.add(500);
            pile.add(card);
        }
        for(int i=0; i<2; i++){ // add 
            ArrayList<Object> card = new ArrayList<Object>(); 
            card.add(Cards.SeaBattle);
            card.add(4);
            card.add(1000);
            pile.add(card);
        }
        for(int i=6; i<35; i++){
            ArrayList<Object> card = new ArrayList<Object>(); 
            card.add(Cards.nop);
            card.add(i+1);
            pile.add(card);        
        }
        Collections.shuffle(pile);
        return pile;
    }

    public static ArrayList<Object> draw(ArrayList<ArrayList<Object>> pile){
        //ArrayList<Object> drawnCard = pile.get(0);
        //pile.get(0);
        //return drawnCard;

        return pile.remove(0);
        
    }
} 