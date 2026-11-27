public class TestSituation {
    
    public static void main(String[] args) {

        System.out.printf("%.3f%n", SituationMultiplier.compute(125, 6, 17.0, 148));
        System.out.printf("%.3f%n", SituationMultiplier.compute(0, 0, 0.0, 148));
        System.out.printf("%.3f%n", SituationMultiplier.compute(150, 4, 18.0, 148));
        System.out.printf("%.3f%n", SituationMultiplier.compute(100, 5, 19.0, 200));

    }

}
