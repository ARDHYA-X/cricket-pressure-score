import java.util.List;

public class TestLoader {

    public static void main(String[] args) throws Exception {

        List<Delivery> deliveries = DeliveryLoader.load("data/match_kohli_pak_2022.csv");

        int kohliBalls = 0;
        int kohliRuns = 0;
        int hardikBalls = 0;
        int hardikRuns = 0;
        int teamTotal = 0;
        int wickets = 0;

        for (Delivery d : deliveries) {
            teamTotal += d.bat + d.extraRuns();

            if (d.wicket) {
                wickets++;
            }
            if (d.striker.equals("Kohli") && d.strikerFaced()) {
                kohliBalls++;
                kohliRuns += d.bat;
            }
            if (d.striker.equals("Hardik") && d.strikerFaced()) {
                hardikBalls++;
                hardikRuns += d.bat;
            }
        }

        System.out.println("Rows: " + deliveries.size());
        System.out.println("Kohli: " + kohliRuns + " off " + kohliBalls);
        System.out.println("Hardik: " + hardikRuns + " off " + hardikBalls);
        System.out.println("Team: " + teamTotal + " with " + wickets + " wickets");
    }
}