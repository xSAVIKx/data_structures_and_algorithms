import java.util.Scanner;

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

    public static int euclidGcd(int a, int b) {
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

    private static int getNewNumberToCheck(int a, int b) {
        int newNumber = a - b;
        while (newNumber > b) {
            newNumber -= b;
        }
        return newNumber;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(euclidGcd(a, b));
    }
}
