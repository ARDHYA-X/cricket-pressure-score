import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CricketApiTest {
    public static void main (String[] args) throws Exception {

        String apiKey = System.getenv("CRICKET_API_KEY");
        if (apiKey == null) {
            System.out.println("CRICKET_API_KEY is not set");
            return;
        }

        String url = "https://api.cricapi.com/v1/currentMatches?apikey=" + apiKey + "&offset=0";
        
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        System.out.println(response.statusCode());
        String body = response.body();
        System.out.println(body.substring(0, Math.min(500, body.length())));

    }
}