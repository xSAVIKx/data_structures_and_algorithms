/**
 * Created by iuriis on 05.07.2016.
 */
public class GCD {
    public static long naiveGcd(long a, long b) {
        int best = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                best = i;
            }
        }
        return best;
    }

    public static long euclidGcd(long a, long b) {
        if (a == 1 || b == 1) {
            return 1;
        }
        if (a % b == 0) {
            return b;
        }
        if (b % a == 0) {
            return a;
        }
        if (a > b) {
            return euclidGcd(getNewNumberToCheck(a, b), b);
        }
        return euclidGcd(a, getNewNumberToCheck(b, a));
    }

    private static long getNewNumberToCheck(long a, long b) {
        long newNumber = a - b;
        while(newNumber>b){
            newNumber-=b;
        }
        return newNumber;
    }
}
