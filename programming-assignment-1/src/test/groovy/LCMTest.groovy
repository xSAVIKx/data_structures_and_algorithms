import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll


class LCMTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "lcm of #a and #b should be #expectedResult"() {
        expect:
        LCM.lcm(a, b) == expectedResult
        where:
        a        | b        || expectedResult
        6        | 8        || 24
        28851538 | 1183019  || 1933053046
        14159572 | 63967072 || 226436590403296
    }
}