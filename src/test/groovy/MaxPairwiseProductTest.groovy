import org.junit.Rule
import org.junit.rules.Stopwatch
import spock.lang.Specification

class MaxPairwiseProductTest extends Specification {
    @Rule
    public Stopwatch stopwatch = new MeasuringRule()

    def "simple test"() {
        given:
        int n = 3;
        def numbers = [1, 3, 5]
        def data = new StringBuilder();
        data.append(n).append('\n')
        numbers.each { number -> data.append(number).append(' ') }
        def input = new ByteArrayInputStream(data.toString().getBytes());
        System.setIn(input);
        def out = Mock(PrintStream)
        System.setOut(out)
        when:
        MaxPairwiseProduct.main(null)
        then:
        1 * out.println(15)
    }

    def "big test"() {
        given:
        def input = new FileInputStream('src/test/groovy/randomTest.dat')
        System.setIn(input);
        def out = Mock(PrintStream)
        System.setOut(out)
        when:
        MaxPairwiseProduct.main(null)
        then:
        1 * out.println(39998800008)

    }

}
