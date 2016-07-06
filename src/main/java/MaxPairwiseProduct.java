import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProductFast(long[] numbers) {
        int n = numbers.length;
        int max1Index = -1;
        int max2Index = -1;
        for (int i = 0; i < n; i++) {
            if (max1Index == -1 || numbers[i] >= numbers[max1Index]) {
                if (max1Index != max2Index) {
                    max2Index = max1Index;
                }
                max1Index = i;
            }
        }
        for (int i = max1Index+1 ; i < n;i++){
            if (max2Index == -1 || numbers[i] >= numbers[max2Index]){
                max2Index = i;
            }
        }
        return numbers[max1Index] * numbers[max2Index];
    }

    static long getMaxPairwiseProduct(long[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
//        System.out.println(getMaxPairwiseProduct(numbers));
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}