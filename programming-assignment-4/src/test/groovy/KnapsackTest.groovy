import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll


class KnapsackTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "optimal weight of W=#W and n=#n should be #expectedResult"() {
        expect:
        Knapsack.optimalWeight(capacity, weights) == expectedResult
        where:
        weights                  | capacity || expectedResult
        [1, 4, 8] as int[]       | 10       || 9
        [1, 2, 3, 6, 8] as int[] | 90       || 20
    }
}