import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification


class InversionsTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    def "number of inversions in #a should be #expectedResult"() {
        given:
        expect:
        Inversions.getNumberOfInversions(a, new int[a.length], 0, a.length-1) == expectedResult
        where:
        a                        || expectedResult
        [2, 3, 9, 2, 9] as int[] || 2
    }
}