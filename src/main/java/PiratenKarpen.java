import pk.Player;
import pk.Simulator;
import org.apache.logging.log4j.*;


public class PiratenKarpen {

    private static final Logger logger = LogManager.getLogger(PiratenKarpen.class);

    public static void main(String[] args) {
        logger.trace("Entering Piraten Karpen Simulator");
        //System.out.println("Welcome to Piraten Karpen Simulator!");
        Player p1 = new Player();
        Player p2 = new Player();
        Simulator.play(p1, p2, args[0], args[1]);
        System.out.println("Player 1 won "+p1.getPercentWins()+"% of the games.");
        System.out.println("Player 2 won "+p2.getPercentWins()+"% of the games.");
        logger.trace("Exiting Piraten Karpen Simulator");
    }
}
