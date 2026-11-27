public class SituationMultiplier {

    static final double MIN_MULTIPLIER = 1.0;
    static final double MAX_MULTIPLIER = 2.0;

    static final double RATE_WEIGHT = 0.5;
    static final double WICKET_WEIGHT = 0.3;
    static final double END_WEIGHT = 0.2;



    static int oversToBalls(double overs) {

        int wholeOvers = (int) overs;
        int extraBalls = (int) Math.round((overs - wholeOvers) * 10);
        return wholeOvers * 6 + extraBalls;

    }
    static double compute(int runsScored, int wicketsLost, double overs, int target) {

        int ballsBowled = oversToBalls(overs);
        int ballsLeft = 120 - ballsBowled;
        int runsNeeded = target - runsScored;

        if (runsNeeded <= 0) {
            return MIN_MULTIPLIER;
        }
        if (ballsLeft <= 0) {
            return MAX_MULTIPLIER;
        }
        if (wicketsLost >= 10) {
            return MAX_MULTIPLIER;
        }

        if (ballsBowled == 0) {
            return MIN_MULTIPLIER;
        }

        double requiredRate = runsNeeded * 6.0 / ballsLeft;
        double currentRate = runsScored * 6.0 / ballsBowled;

        //If the required run rate is greater than 36, player practically cannot win the game.
        if (requiredRate >= 36) {
            return MAX_MULTIPLIER;
        } 

        double rateTerm = Math.max(0, Math.min(1, (requiredRate - currentRate) / 6.0));
        double wicketTerm = wicketsLost / 10.0;
        double endTerm = 1 - ballsLeft / 120.0;

        
        double weightedSum = (RATE_WEIGHT * rateTerm) + (WICKET_WEIGHT * wicketTerm) + (END_WEIGHT * endTerm);

        return MIN_MULTIPLIER + (MAX_MULTIPLIER - MIN_MULTIPLIER) * weightedSum;

    }
}