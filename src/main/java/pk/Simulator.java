import java.util.Random;

public class Simulator{
    Player player;
    public static int play(Player player){
        int roll = 8;
        int numDice = 8;
        Random rand = new Random();
        while(1) {
            player.rolledFaces = Dice.rollAll(roll);
            for(int j=0; j<9; j++){
                if(player.rolledFaces[j]=="GOLD"||player.rolledFaces[j] =="DIAMOND"){
                    player.score += 100;
                }
                player.numSkulls += (player.rolledFaces[j] == "SKULL"); 
                numDice -= (player.rolledFaces[j] == "SKULL"); 
                if(player.numSkulls >= 3)
                    break; 
            }
            if(player.numSkulls >=3)
                break;
            
            numDice = rand.nextInt(numDice);
        }
        return player.score; 
    }

}