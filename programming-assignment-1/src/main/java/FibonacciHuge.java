import java.util.Scanner;

public class FibonacciHuge {

    public static long getFibonacciHuge(long n, long m) {
        long a11 = 1, a12 = 1, a21 = 1, a22 = 0; //матрица оператора
        long r11 = 1, r12 = 0; //вектор-столбец результа
        long q11, q12, q21, q22; //вспомогательная матрица при перемножении
        while (n > 0) {
            if ((n & 1) == 1) {
                q11 = (r11 * a11 + r12 * a21) % m;
                q12 = (r11 * a12 + r12 * a22) % m;
                r11 = q11;
                r12 = q12;
            }
            q11 = (a11 * a11 + a12 * a21) % m;
            q12 = (a11 * a12 + a12 * a22) % m;
            q21 = (a21 * a11 + a22 * a21) % m;
            q22 = (a21 * a12 + a22 * a22) % m;
            a11 = q11;
            a12 = q12;
            a21 = q21;
            a22 = q22;

            n >>= 1;
        }
        return r12; //возвращаем Fn
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

