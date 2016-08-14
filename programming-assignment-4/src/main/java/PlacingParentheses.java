import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class PlacingParentheses {
    public static long getMaximValue(String exp) {
        long[] digits = digits(exp);
        char[] operands = operands(exp);
        return parentheses(digits, operands);
    }

    private static long parentheses(long[] digits, char[] operands) {
        int n = digits.length;
        long[][] min = new long[n][n];
        long[][] max = new long[n][n];
        for (int i = 0; i < n; i++) {
            //base case when sub expression involves 1 digit
            min[i][i] = digits[i];
            max[i][i] = digits[i];
        }
        for (int i = 1; i < n ; i++) {
            for (int j = 1; j <= n - i; j++) {
                int k = j + i;
                long[] result = minAndMax(j - 1, k - 1, min, max, operands);
                min[j - 1][k - 1] = result[0];
                max[j - 1][k - 1] = result[1];
            }
        }
        return max[0][n - 1];
    }

    private static long[] minAndMax(int i, int j, long[][] min, long[][] max, char[] operands) {
        long minimum = Long.MAX_VALUE;
        long maximum = Long.MIN_VALUE;
        for (int k = i; k <= j - 1; k++) {
            char operand = operands[k];
            long max_max = eval(max[i][k], max[k + 1][j], operand);
            long max_min = eval(max[i][k], min[k + 1][j], operand);
            long min_max = eval(min[i][k], max[k + 1][j], operand);
            long min_min = eval(min[i][k], min[k + 1][j], operand);
            minimum = getMin(minimum, max_max, max_min, min_max, min_min);
            maximum = getMax(maximum, max_max, max_min, min_max, min_min);
        }
        return new long[]{minimum, maximum};
    }

    private static long getMin(long min, long a, long b, long c, long d) {
        return min(d, min(c, min(b, min(min,a))));
    }

    private static long getMax(long max, long a, long b, long c, long d) {
        return max(d, max(c, max(b, max(max,a))));
    }

    private static char[] operands(String exp) {
        char[] operands = new char[exp.length() / 2];
        int counter = 0;
        for (int i = 1; i < exp.length(); i = i + 2) {
            operands[counter++] = exp.charAt(i);
        }
        return operands;
    }

    private static long[] digits(String exp) {
        long[] digits = new long[(exp.length() / 2) + 1];
        int counter = 0;
        for (int i = 0; i < exp.length(); i = i + 2) {
            String s = String.valueOf(exp.charAt(i));
            digits[counter++] = Integer.parseInt(s);
        }
        return digits;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

