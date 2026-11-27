public class Delivery {
    
    int number;
    String ball;
    String striker;
    int bat;
    String extra;
    boolean wicket;

    // A wide or a no-ball doesn't count toward the over, so it isn't a legal delivery.
    boolean isLegal() {
        return !extra.startsWith("wd") && !extra.startsWith("nb");
    }

    // A wide isn't faced by the batter. A no-ball, byes and leg byes still are.
    boolean strikerFaced() {
        return !extra.startsWith("wd");
    }

    // Runs added to the team on top of the runs off the bat, for example 3 for "wd3".
    int extraRuns() {
        if (extra.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(extra.replaceAll("[a-z]", ""));
    }

}
