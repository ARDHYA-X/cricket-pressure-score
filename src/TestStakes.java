import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestStakes {
    public static void main (String[] args) throws Exception {
        
        String text = Files.readString(Path.of("data/stakes.json"));
        StakesTable table = new Gson().fromJson(text, StakesTable.class);
        
        for (StakesTier tier : table.tiers) {
            
            System.out.println(tier.level + " " + tier.name + " " + tier.multiplier);
        
        }
    }
}