package pk;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;


public class CardDeck {

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
        for(int i=0; i<4; i++){ // add 
            ArrayList<Object> card = new ArrayList<Object>(); 
            card.add(Cards.MonkeyBuisness);
            card.add(i+1);
            card.add(null);
            pile.add(card);
        }

        for(int i=10; i<35; i++){
            ArrayList<Object> card = new ArrayList<Object>(); 
            card.add(Cards.nop);
            card.add(i+1);
            pile.add(card);        
        }
        Collections.shuffle(pile);
        return pile;
    }

    public static ArrayList<Object> draw(ArrayList<ArrayList<Object>> pile){
        return pile.remove(0);
    }
} 