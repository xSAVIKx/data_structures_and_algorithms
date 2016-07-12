import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll

import static FibonacciHuge.getFibonacciHuge

class FibonacciHugeTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    @Unroll
    def "#n number in Fibonacci sequence mod 2 should be #expectedResult"() {
        given:
        def m = 2
        expect:
        getFibonacciHuge(n, m) == expectedResult
        where:
        n  || expectedResult
        0  || 0
        1  || 1
        2  || 1
        3  || 0
        4  || 1
        5  || 1
        6  || 0
        7  || 1
        8  || 1
        9  || 0
        10 || 1
        11 || 1
        12 || 0
        13 || 1
        14 || 1
        15 || 0
    }

    @Unroll
    def "#n number in Fibonacci sequence mod 3 should be #expectedResult"() {
        given:
        def m = 3
        expect:
        getFibonacciHuge(n, m) == expectedResult
        where:
        n  || expectedResult
        0  || 0
        1  || 1
        2  || 1
        3  || 2
        4  || 0
        5  || 2
        6  || 2
        7  || 1
        8  || 0
        9  || 1
        10 || 1
        11 || 2
        12 || 0
        13 || 2
        14 || 2
        15 || 1
    }

    @Unroll
    def "#n number in Fibonacci sequence mod #m should be #expectedResult"() {
        expect:
        getFibonacciHuge(n, m) == expectedResult
        where:
        n               | m     || expectedResult
        281621358815590 | 30524 || 11963
    }
}