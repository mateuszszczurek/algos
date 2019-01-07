package com.algos

import spock.lang.Specification

class ArrayUtilsTest extends Specification {

    def "should invert array with even amount of elements"() {
        given:
        def input = [1, 4, 6, 9 , 10, 12] as int[]

        when:
        def result = ArrayUtils.reverse(input)

        then:
        result == [12, 10, 9, 6, 4, 1] as int[]
    }

    def "should invert array with uneven amount of elements"() {
        given:
        def input = [1, 4, 6, 9 , 10, 12, 13] as int[]

        when:
        def result = ArrayUtils.reverse(input)

        then:
        result == [13, 12, 10, 9, 6, 4, 1] as int[]
    }

    def "should invert inline array with even amount of elements"() {
        given:
        def input = [1, 4, 6, 9 , 10, 12] as int[]

        when:
        ArrayUtils.reverseInline(input)

        then:
        input == [12, 10, 9, 6, 4, 1] as int[]
    }

    def "should invert inline array with uneven amount of elements"() {
        given:
        def input = [1, 4, 6, 9 , 10, 12, 13] as int[]

        when:
        ArrayUtils.reverseInline(input)

        then:
        input == [13, 12, 10, 9, 6, 4, 1] as int[]
    }


}
