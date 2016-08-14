import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll


class LCS3Test extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "lcs3 should return #expected result for a=#a, b=#b, c=#c"() {
        expect:
        LCS3.lcs3(a, b, c) == expectedResult
        where:
        a                        | b                               | c                           || expectedResult
        [1, 2, 3] as int[]       | [2, 1, 3] as int[]              | [1, 3, 5] as int[]          || 2
        [8, 3, 2, 1, 7] as int[] | [8, 2, 1, 3, 8, 10, 7] as int[] | [6, 8, 3, 1, 4, 7] as int[] || 3
    }
}