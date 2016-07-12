import java.util.Scanner;

public class LCM {
    public static long lcm(int a, int b) {
        return a * (long)(b / gcd(a, b));
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm(a, b));
    }

    private static int gcd(int a, int b) {
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
            return gcd(getNewNumberToCheck(a, b), b);
        }
        return gcd(a, getNewNumberToCheck(b, a));
    }

    private static int getNewNumberToCheck(int a, int b) {
        int newNumber = a - b;
        while (newNumber > b) {
            newNumber -= b;
        }
        return newNumber;
    }
}
