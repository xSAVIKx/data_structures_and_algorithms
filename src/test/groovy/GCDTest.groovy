import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification

import static GCD.euclidGcd
import static GCD.naiveGcd

/**
 * Created by iuriis on 05.07.2016.
 */
class GCDTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    def "naiveGcd"() {
        expect:
        naiveGcd(2, 3) == 1
        naiveGcd(5, 10) == 5
        naiveGcd(223, 124) == 1
        naiveGcd(510, 2010) == 30
        naiveGcd(1024, 5012) == 4
    }

    def "euclidGcd"() {
        expect:
        euclidGcd(2, 3) == 1
        euclidGcd(5, 10) == 5
        euclidGcd(223, 124) == 1
        euclidGcd(510, 2010) == 30
        euclidGcd(1024, 5012) == 4
    }
}
