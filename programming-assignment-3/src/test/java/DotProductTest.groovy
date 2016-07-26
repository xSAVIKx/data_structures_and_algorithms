import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification


class DotProductTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()
}