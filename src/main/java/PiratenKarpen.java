import pk.Player;
import pk.Simulator;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        Player p1 = new Player();
        Player p2 = new Player();
        Simulator.play(p1, p2);
    }
}
