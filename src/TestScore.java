public class TestScore {

    public static void main (String[] args) {

        System.out.printf("%.3f%n", PressureScore.compute(0, 1.376, 1.0));
        System.out.printf("%.3f%n", PressureScore.compute(3.909, 1.376, 1.0));
        System.out.printf("%.3f%n", PressureScore.compute(3.909, 1.376, 1.2));
        System.out.printf("%.3f%n", PressureScore.compute(50, 2, 1.2));

    }


    
}
