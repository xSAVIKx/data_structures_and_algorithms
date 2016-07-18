import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll


class ChangeTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "getChange for #m should return #expectedResult"() {
        expect:
        Change.getChange(m) == expectedResult
        where:
        m  || expectedResult
        2  || 2
        6  || 2
        11 || 2
        14 || 5
        28 || 6
    }
}