import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll


class DifferentSummandsTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "optimalSummands of #n should be #expectedResult"() {
        expect:
        DifferentSummands.optimalSummands(n) == expectedResult
        where:
        n || expectedResult
        2 || [2]
        6 || [1, 2, 3]
        8 || [1, 2, 5]
        3 || [1, 2]
    }
}