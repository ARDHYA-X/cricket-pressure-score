import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestBaselines {

    public static void main(String[] args) throws Exception {
        
        String text = Files.readString(Path.of("data/baselines.json"));
        BaselineTable table = new Gson().fromJson(text, BaselineTable.class);

        System.out.println(table.getStrikeRate("Virat Kohli"));
        System.out.println(table.getStrikeRate("Some Unknown Player"));
    }
}