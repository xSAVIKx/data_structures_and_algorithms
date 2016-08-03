import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll

import static PointsAndSegments.*

class PointsAndSegmentsTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "naiveCountSegments should return #expectedResult for starts: #starts, ends: #ends and points: #points"() {
        expect:
        naiveCountSegments(starts, ends, points) == expectedResult
        where:
        starts          | ends             | points                  || expectedResult
        [0, 7] as int[] | [5, 10] as int[] | [1, 6, 11] as int[]     || [1, 0, 0] as int[]
        [-10] as int[]  | [10] as int[]    | [-100, 100, 0] as int[] || [0, 0, 1] as int[]

    }

    @Unroll
    def "fastCountSegments should return #expectedResult for starts: #starts, ends: #ends and points: #points"() {
        expect:
        fastCountSegments(starts, ends, points) == expectedResult
        where:
        starts          | ends             | points                  || expectedResult
        [0, 7] as int[] | [5, 10] as int[] | [1, 6, 11] as int[]     || [1, 0, 0] as int[]
        [-10] as int[]  | [10] as int[]    | [-100, 100, 0] as int[] || [0, 0, 1] as int[]

    }

    def s(start, end) {
        new Segment(start, end)
    }
}