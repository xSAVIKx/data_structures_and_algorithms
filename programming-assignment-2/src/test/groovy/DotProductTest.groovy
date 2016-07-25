import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll


class DotProductTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "minDotProduct of #a and #b should be #expectedResult"() {
        expect:
        DotProduct.minDotProduct(a, b) == expectedResult
        where:
        a                   | b                   || expectedResult
        [23] as int[]       | [39] as int[]       || 897
        [1, 3, -5] as int[] | [-2, 4, 1] as int[] || -25
    }
}