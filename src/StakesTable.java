import java.util.List;

public class StakesTable {
    List<StakesTier> tiers;

    public double getMultiplier(int level) {

        for(StakesTier tier : tiers) {

            if (tier.level == level) {
                
                return tier.multiplier;

            }
        }
        //An unknown tier should not affect the score, so we return 1.0 as a default multiplier.
        return 1.0;

    }

}
