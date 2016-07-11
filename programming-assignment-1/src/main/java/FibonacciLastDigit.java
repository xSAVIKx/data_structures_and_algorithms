import java.util.Scanner;

public class FibonacciLastDigit {
    public static int getFibonacciLastDigit(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fibList = new int[n + 1];
        fibList[0] = 0;
        fibList[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibList[i] = (fibList[i - 1] + fibList[i - 2]) % 10;
        }
        return fibList[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}

