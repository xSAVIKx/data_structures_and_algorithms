import spock.lang.Specification

class CarFuelingTest extends Specification {
    def "simple test"() {
        expect:
        CarFueling.minRefills(x, x.length, L) == 1
        where:
        L   || x
        400 || [0, 200, 375, 550, 750, 950] as int[]
    }
}