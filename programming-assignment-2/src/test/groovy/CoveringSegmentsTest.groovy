import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification


class CoveringSegmentsTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()
}