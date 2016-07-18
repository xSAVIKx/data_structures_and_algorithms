import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll

import static FractionalKnapsack.Item
import static FractionalKnapsack.getOptimalValue


class FractionalKnapsackTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "optimal value for Fractional Knapsack with #capacity capacity should be #expectedResult"() {
        expect:
        getOptimalValue(capacity, items) == expectedResult
        where:
        capacity | items                                                              || expectedResult
        50       | [getItem(60, 20), getItem(100, 50), getItem(120, 30)]              || 180d
        10       | [getItem(500, 30)]                                                 || 166.6667
        15       | [getItem(1, 100), getItem(100, 1), getItem(1, 50), getItem(50, 1)] || 150.26
    }

    def getItem(value, weight) {
        return new Item(value, weight, (double) value / (double) weight)
    }

}