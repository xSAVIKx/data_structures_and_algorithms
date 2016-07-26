import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll

import static BinarySearch.binarySearch
import static BinarySearch.linearSearch


class BinarySearchTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "index of #x should be #expectedResult searching it in [1, 5, 8, 12, 13] with linearSearch"() {
        given:
        def a = [1, 5, 8, 12, 13] as int[]
        expect:
        linearSearch(a, x) == expectedResult
        where:
        x  || expectedResult
        8  || 2
        1  || 0
        23 || -1
        1  || 0
        11 || -1
    }

    @Unroll
    def "index of #x should be #expectedResult searching it in [1, 5, 8, 12, 13] with binarySearch"() {
        given:
        def a = [1, 5, 8, 12, 13] as int[]
        expect:
        binarySearch(a, x) == expectedResult
        where:
        x  || expectedResult
        8  || 2
        1  || 0
        23 || -1
        1  || 0
        11 || -1
    }
}