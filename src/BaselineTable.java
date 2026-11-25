import java.util.List;

public class BaselineTable {
    double defaultStrikeRate;
    
    List<PlayerBaseline> players;

    double getStrikeRate(String name) {
        
        for (PlayerBaseline player : players) {
            
            if (player.name.equalsIgnoreCase(name)) {
             
                return player.strikeRate;

            }
            
            return defaultStrikeRate;

        }
        
        return defaultStrikeRate;

    }
}