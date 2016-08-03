import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {
    public static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0; i < points.length; i++) {
            int index1 = 0;
            while (index1 < starts.length) {
                if (starts[index1] > points[i]) {
                    break;
                }
                index1++;
            }
            int index2 = 0;
            while (index2 < ends.length) {
                if (ends[index2] >= points[i]) {
                    break;
                }
                index2++;
            }

            cnt[i] = index1 - index2;
        }

        return cnt;
    }

    public static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        // int[] cnt = naiveCountSegments(starts, ends, points);
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }


}

