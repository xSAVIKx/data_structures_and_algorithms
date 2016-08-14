import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll


class PlacingParenthesesTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "getMaximValue for expression=#expression should return #expectedResult"() {
        expect:
        PlacingParentheses.getMaximValue(expression) == expectedResult
        where:
        expression    || expectedResult
        "1+5"         || 6
        "6-1"         || 5
        "5-8+7*4-8+9" || 200
    }
}