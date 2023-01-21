import pk.Player;
import pk.Simulator;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        Player p1 = new Player();
        Player p2 = new Player();
        Simulator.play(p1, p2);
        System.out.println("Player 1 won "+p1.getPercentWins()+"% of the games.");
        System.out.println("Player 2 won "+p2.getPercentWins()+"% of the games.");
    }
}
