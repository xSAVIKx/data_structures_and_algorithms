import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll


class MajorityElementTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "majorityElement for #a should be #expectedResult"() {
        expect:
        MajorityElement.getMajorityElement(a, 0, a.size() - 1) == expectedResult
        where:
        a                        || expectedResult
        [2, 3, 9, 2, 2] as int[] || 2
        [1, 2, 3, 4] as int[]    || -1
    }
}