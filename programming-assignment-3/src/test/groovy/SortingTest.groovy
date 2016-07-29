import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll


class SortingTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "sorting with randomizedQuickSort should sort #a into #expectedResult"() {
        when:
        Sorting.randomizedQuickSort(a, 0, a.length - 1)
        then:
        a == expectedResult
        where:
        a                        || expectedResult
        [2, 3, 9, 2, 2] as int[] || [2, 2, 2, 3, 9] as int[]
    }

    @Unroll
    def "sorting with randomizedQuickSortP3 should sort #a into #expectedResult"() {
        when:
        Sorting.randomizedQuickSortP3(a, 0, a.length - 1)
        then:
        a == expectedResult
        where:
        a                        || expectedResult
        [2, 3, 9, 2, 2] as int[] || [2, 2, 2, 3, 9] as int[]
        [2, 3, 9, 2, 9] as int[] || [2, 2, 3, 9, 9] as int[]
    }
}