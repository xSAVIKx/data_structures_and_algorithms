import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll

import static Fib.fibList
import static Fib.fibRecurs

class FibTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()


    @Unroll
    def "fibRecurs | #n number in Fibonacci sequence should be #expectedResult"() {
        expect:
        fibRecurs(n) == expectedResult
        where:
        n  || expectedResult
        0  || 0
        1  || 1
        2  || 1
        3  || 2
        4  || 3
        5  || 5
        10 || 55
        12 || 144
        20 || 6765
    }

    @Unroll
    def "fibList | #n number in Fibonacci sequence should be #expectedResult"() {
        expect:
        fibList(n) == expectedResult
        where:
        n  || expectedResult
        0  || 0
        1  || 1
        2  || 1
        3  || 2
        4  || 3
        5  || 5
        10 || 55
        12 || 144
        20 || 6765
    }
}