import java.util.Scanner;

import static java.lang.Math.max;

public class LCS3 {

    public static int lcs3(int[] a, int[] b, int[] c) {
        int m = a.length;
        int n = b.length;
        int o = c.length;
        int[][][] values = new int[m + 1][n + 1][o + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < o + 1; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        values[i][j][k] = 0;
                        continue;
                    }
                    if (a[i - 1] == b[j - 1] && (a[i - 1] == c[k - 1])) {
                        values[i][j][k] = 1 + values[i - 1][j - 1][k - 1];
                    } else {
                        values[i][j][k] = maximumValueOfPermutations(values, i, j, k);
                    }
                }
            }
        }
        return values[m][n][o];
    }

    private static int maximumValueOfPermutations(int[][][] values, int i, int j, int k) {
        int first = values[i][j][k - 1];
        int second = values[i][j - 1][k];
        int firstPairMaximum = max(first, second);
        int third = values[i - 1][j][k];
        int fourth = values[i][j - 1][k - 1];
        int secondPairMaximum = max(third, fourth);
        int fifth = values[i - 1][j][k - 1];
        int sixth = values[i - 1][j - 1][k];
        int thirdPairMaximum = max(fifth, sixth);
        return max(firstPairMaximum, max(secondPairMaximum, thirdPairMaximum));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

