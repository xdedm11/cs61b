public class TestPlanet {
    /**  creates two planets and prints out the pairwise force between them.  */
    public static void main(String[] args) {
        checkPairwiseForce();
    }

    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     *  Checks the Planet class to make sure calcDistance works.
     */
    private static void checkPairwiseForce() {
        System.out.println("Checking pairwise force...");

        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");

        checkEquals(p1.calcForceExertedBy(p2), p2.calcForceExertedBy(p1), "pairwise", 0.01);
    }
}
