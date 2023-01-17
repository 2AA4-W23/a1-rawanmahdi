import pk.Dice;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        for(int i=1; i<43; i++){
            System.out.println("Starting game ", i, " of 42");
            
        }
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        System.out.println(myDice.roll());
        Object[] faces = Dice.roll8();
        for(int i=0; i<8; i++){
            System.out.println(faces[i]);
        }
        System.out.println("That's all folks!");
        


    }
    
}
