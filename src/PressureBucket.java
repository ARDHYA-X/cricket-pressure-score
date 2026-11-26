public class PressureBucket {
    
    static final double DECAY = 0.95;
    static final double AHEAD_WEIGHT = 0.5;

    double level;
    int ballsFaced;
    int runsScored;
    double baselineStrikeRate;

    PressureBucket(double baselineStrikeRate) {
        this.baselineStrikeRate = baselineStrikeRate;
    }

    void recordBall(int runsOnBall) {
        ballsFaced++;
        runsScored += runsOnBall;

        if (ballsFaced < 4) {
            return;
        }

        double expectedRunsPerBall = baselineStrikeRate / 100;
        double gap = expectedRunsPerBall - runsOnBall;
        if (gap < 0) {
            gap = gap * AHEAD_WEIGHT;
        }
        level = Math.max(0, level * DECAY + gap);
    }
}