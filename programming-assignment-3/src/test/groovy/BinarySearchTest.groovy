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
    def "index of #x should be #expectedResult searching it in #a with linearSearch"() {
        expect:
        linearSearch(a, x) == expectedResult
        where:
        a                          | x  || expectedResult
        [1, 5, 8, 12, 13] as int[] | 8  || 2
        [1, 5, 8, 12, 13] as int[] | 1  || 0
        [1, 5, 8, 12, 13] as int[] | 23 || -1
        [1, 5, 8, 12, 13] as int[] | 1  || 0
        [1, 5, 8, 12, 13] as int[] | 11 || -1
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 1  || -1
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 2  || 0
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 3  || 1
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 4  || 2
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 5  || 3
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 6  || 4
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 7  || 5
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 8  || 6
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 9  || 7
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 10 || 8
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 11 || 9
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 12 || -1
    }

    @Unroll
    def "index of #x should be #expectedResult searching it in #a with binarySearch"() {
        expect:
        binarySearch(a, x) == expectedResult
        where:
        a                                         | x  || expectedResult
        [1, 5, 8, 12, 13] as int[]                | 8  || 2
        [1, 5, 8, 12, 13] as int[]                | 1  || 0
        [1, 5, 8, 12, 13] as int[]                | 23 || -1
        [1, 5, 8, 12, 13] as int[]                | 1  || 0
        [1, 5, 8, 12, 13] as int[]                | 11 || -1
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 1  || -1
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 2  || 0
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 3  || 1
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 4  || 2
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 5  || 3
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 6  || 4
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 7  || 5
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 8  || 6
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 9  || 7
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 10 || 8
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 11 || 9
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[] | 12 || -1
    }
}