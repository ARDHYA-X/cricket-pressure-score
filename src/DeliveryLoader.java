import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DeliveryLoader {

    static List<Delivery> load(String path) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path));
        List<Delivery> deliveries = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split(",", -1);

            Delivery d = new Delivery();
            d.number = Integer.parseInt(parts[0]);
            d.ball = parts[1];
            d.striker = parts[2];
            d.bat = Integer.parseInt(parts[3]);
            d.extra = parts[4];
            d.wicket = parts[5].equals("W");
            deliveries.add(d);
        }
        return deliveries;
    }
}