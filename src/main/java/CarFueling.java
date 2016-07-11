public class CarFueling {
    private static final int IMPOSSIBLE = -1;

    public static int minRefills(int[] x, int n, int L) {
        int numRefills = 0, currentRefill = 0;
        while (currentRefill < n) {
            int lastRefill = currentRefill;
            while (currentRefill < n-1 && (x[currentRefill + 1] - x[lastRefill]) <= L) {
                currentRefill++;
            }
            if (currentRefill == lastRefill) {
                return IMPOSSIBLE;
            }
            if (currentRefill < n) {
                numRefills++;
            }
        }
        return numRefills;
    }
}
