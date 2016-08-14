import java.util.*;

public class Knapsack {
    private static int max(int a, int b) {
        return (a > b)? a:b;
    }

    public static int optimalWeight(int capacity, int[] weights) {
        int n = weights.length;
        int resultsMatrix[][] = new int[n+1][capacity+1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i==0 || w==0)
                    resultsMatrix[i][w] = 0;
                else if (weights[i-1] <= w)
                    resultsMatrix[i][w] = max(weights[i-1] + resultsMatrix[i-1][w-weights[i-1]],  resultsMatrix[i-1][w]);
                else
                    resultsMatrix[i][w] = resultsMatrix[i-1][w];
            }
        }
        return resultsMatrix[n][capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

