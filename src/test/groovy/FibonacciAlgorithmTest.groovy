import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification

import static FibonacciAlgorithm.fibList
import static FibonacciAlgorithm.fibRecurs

/**
 * Created by iuriis on 05.07.2016.
 */
class FibonacciAlgorithmTest extends Specification {

    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    def "fibRecurs"() {
        expect:
        fibRecurs(0) == 0
        fibRecurs(1) == 1
        fibRecurs(2) == 1
        fibRecurs(3) == 2
        fibRecurs(4) == 3
        fibRecurs(5) == 5
        fibRecurs(12) == 144
        fibRecurs(20) == 6765
    }

    def "fibList"() {
        expect:
        fibList(0) == 0
        fibList(1) == 1
        fibList(2) == 1
        fibList(3) == 2
        fibList(4) == 3
        fibList(5) == 5
        fibList(12) == 144
        fibList(20) == 6765
    }
}
