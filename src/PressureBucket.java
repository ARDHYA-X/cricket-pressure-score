public class PressureBucket {
    
    static final double DECAY = 0.95;
    static final double AHEAD_WEIGHT = 0.5;
    static final int GRACE_BALLS = 1; // balls a batter faces before the bucket starts moving.

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

        if (ballsFaced <= GRACE_BALLS) {
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