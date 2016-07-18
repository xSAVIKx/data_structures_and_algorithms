import java.util.Scanner;

public class Change {
    private final static int COIN_DENOMINATION_10 = 10;
    private final static int COIN_DENOMINATION_5 = 5;
    private final static int COIN_DENOMINATION_1 = 1;
    private final static int[] COIN_DENOMINATIONS = new int[]{COIN_DENOMINATION_10, COIN_DENOMINATION_5, COIN_DENOMINATION_1};

    public static int getChange(int m) {
        int coinsAmount = 0;
        for (int coinDenomination : COIN_DENOMINATIONS) {
            while (m >= coinDenomination) {
                m -= coinDenomination;
                coinsAmount++;
            }
        }
        return coinsAmount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

