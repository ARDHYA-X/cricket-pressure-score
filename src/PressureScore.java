public class PressureScore {
    
    static final double FLOOR = 2.0;
    static final double CEILING = 9.0;
    static final double SITUATION_WEIGHT = 6.2;
    // Placeholder to be tuned against real matches.
    // How many points of pressure one unit of the bucket adds above the floor?
    static final double POINTS_PER_UNIT = 0.05;

    public static double compute(double bucketLevel, double situationMultiplier, double stakesMultiplier) {
        
        double raw = bucketLevel * situationMultiplier;

        // Stakes scales only the points above the floor, so a comfortable chase stays at 2 whatever the occasion.
        double pointAboveFloor = (bucketLevel * situationMultiplier * POINTS_PER_UNIT
        + SITUATION_WEIGHT * (situationMultiplier - SituationMultiplier.MIN_MULTIPLIER)) * stakesMultiplier;

        return Math.min(CEILING, FLOOR + pointAboveFloor);

    }

}
