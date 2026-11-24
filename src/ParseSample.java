import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Path;

public class ParseSample {

    public static void main (String[] args) throws Exception {

        String text = Files.readString(Path.of("data/sample_match_info.json"));
        MatchResponse result = new Gson().fromJson(text, MatchResponse.class);

        System.out.println(result.data.name);
        System.out.println(result.data.score.get(0).r);
        System.out.println(result.data.score.get(1).r + " in " + result.data.score.get(1).o + " overs");

    }

}
