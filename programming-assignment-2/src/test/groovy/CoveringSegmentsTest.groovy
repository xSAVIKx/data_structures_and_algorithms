import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll

import static CoveringSegments.Segment
import static CoveringSegments.optimalPoints


class CoveringSegmentsTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "optimalPoints should be #expectedResult"() {
        expect:
        optimalPoints(segments) == expectedResult
        where:
        segments                             || expectedResult
        [s(1, 3), s(2, 5), s(3, 6)]          || [3]
        [s(4, 7), s(1, 3), s(2, 5), s(5, 6)] || [3, 6]
    }

    def s(start, end) {
        new Segment(start, end)
    }
}