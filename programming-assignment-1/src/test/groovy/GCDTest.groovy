import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll

class GCDTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "naiveGcd | gcd of #a and #b should be #expectedResult"() {
        expect:
        GCD.naiveGcd(a, b) == expectedResult
        where:
        a        | b       || expectedResult
        2        | 3       || 1
        5        | 10      || 5
        223      | 124     || 1
        510      | 2010    || 30
        1024     | 5012    || 4
        28851538 | 1183019 || 17657
        18       | 35      || 1
    }

    @Unroll
    def "euclidGcd | gcd of #a and #b should be #expectedResult"() {
        expect:
        GCD.euclidGcd(a, b) == expectedResult
        where:
        a        | b       || expectedResult
        2        | 3       || 1
        5        | 10      || 5
        223      | 124     || 1
        510      | 2010    || 30
        1024     | 5012    || 4
        28851538 | 1183019 || 17657
        18       | 35      || 1
    }
}
