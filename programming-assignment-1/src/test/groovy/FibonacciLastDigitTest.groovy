import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification
import spock.lang.Unroll

import static FibonacciLastDigit.getFibonacciLastDigit


class FibonacciLastDigitTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()


    @Unroll
    def "last digit of #n number in Fibonacci sequence should be #expectedResult"() {
        expect:
        getFibonacciLastDigit(n) == expectedResult
        where:
        n  || expectedResult
        0  || 0
        1  || 1
        2  || 1
        3  || 2
        4  || 3
        5  || 5
        6  || 8
        7  || 3
        10 || 5
        12 || 4
        20 || 5
    }
}