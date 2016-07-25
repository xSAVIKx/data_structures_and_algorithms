import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FractionalKnapsack {
    private static final int SCALING_LEVEL = 4;

    public static double getOptimalValue(int capacity, List<Item> items) {
        Collections.sort(items);
        double capacityLeft = capacity;
        double value = 0;
        for (Item item : items) {
            if (Double.compare(capacityLeft, 0) <= 0) {
                return value;
            }
            if (Double.compare(capacityLeft, item.getWeight()) >= 0) {
                value += item.getValue();
                capacityLeft -= item.getWeight();
            } else {
                value += capacityLeft * item.getValuePerWeight();
                capacityLeft -= capacityLeft;
            }
        }

        return new BigDecimal(value).setScale(SCALING_LEVEL, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            int weight = scanner.nextInt();
            items.add(new Item(value, weight, ((double) value / (double) weight)));
        }
        System.out.println(getOptimalValue(capacity, items));
    }

    public static class Item implements Comparable<Item> {
        private final int value;
        private final int weight;
        private final double valuePerWeight;

        public Item(int value, int weight, double valuePerWeight) {
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = valuePerWeight;
        }

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }

        public double getValuePerWeight() {
            return valuePerWeight;
        }

        @Override
        public int compareTo(Item o) {
            return Double.compare(o.getValuePerWeight(), valuePerWeight);
        }
    }
} 
