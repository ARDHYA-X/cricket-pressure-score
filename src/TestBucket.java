public class TestBucket {

    public static void main(String[] args) {

        PressureBucket bucket = new PressureBucket(137.05);
        int[] runs = {0,0,0,0,0,0,4,0,6};

        for (int runsOnBall : runs) {

            bucket.recordBall(runsOnBall);
            System.out.printf("%.3f%n", bucket.level);

        }

    }

}