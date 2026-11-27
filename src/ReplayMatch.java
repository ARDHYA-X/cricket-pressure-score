import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplayMatch {

    static BaselineTable baselines;

    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        StakesTable stakesTable = gson.fromJson(Files.readString(Path.of("data/stakes.json")), StakesTable.class);
        baselines = gson.fromJson(Files.readString(Path.of("data/baselines.json")), BaselineTable.class);
        List<Delivery> deliveries = DeliveryLoader.load("data/match_kohli_pak_2022.csv");

        double stakes = stakesTable.getMultiplier(4);
        int target = 160;
        Map<String, PressureBucket> buckets = new HashMap<>();

        int teamRuns = 0;
        int wickets = 0;
        int legalBalls = 0;

        for (int i = 0; i < deliveries.size(); i++) {
            Delivery d = deliveries.get(i);

            teamRuns += d.bat + d.extraRuns();
            if (d.wicket) {
                wickets++;
            }
            if (d.isLegal()) {
                legalBalls++;
            }

            // Only the batter who faced the ball has his bucket updated; his partner's holds still.
            if (d.strikerFaced()) {
                bucketFor(buckets, d.striker).recordBall(d.bat);
            }

            double overs = legalBalls / 6 + (legalBalls % 6) / 10.0;
            double situation = SituationMultiplier.compute(teamRuns, wickets, overs, target);

            // The score shown belongs to whoever faces the next ball.
            String nextStriker = (i + 1 < deliveries.size()) ? deliveries.get(i + 1).striker : d.striker;
            double score = PressureScore.compute(bucketFor(buckets, nextStriker).level, situation, stakes);

            System.out.printf("%-5s %-11s %.2f%n", d.ball, nextStriker, score);
        }
    }

    static PressureBucket bucketFor(Map<String, PressureBucket> buckets, String name) {
        PressureBucket bucket = buckets.get(name);
        if (bucket == null) {
            bucket = new PressureBucket(baselines.getStrikeRate(name));
            buckets.put(name, bucket);
        }
        return bucket;
    }
}