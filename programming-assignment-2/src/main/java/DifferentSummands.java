import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {
    public static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<>();
        int total = 0;
        int i = 1;
        while (total + i <= n) {
            total += i;
            summands.add(i);
            i++;
        }
        int lastIndex = summands.size() - 1;
        summands.set(lastIndex, summands.get(lastIndex) + n - total);
        //write your code here
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

