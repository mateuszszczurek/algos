import spock.lang.Specification

class MyLinkedListTest extends Specification {

    def "linked list is created empty"() {
        given:
        def linkedList = new  MyLinkedList()

        expect:
        linkedList.size() == 0
    }

    def "items that are put to the keep ordering when retreived"() {
        given:
        def firstItem = "first"
        def secondItem = "second"

        def linkedList = new MyLinkedList()

        when:
        linkedList.add(firstItem)
        linkedList.add(secondItem)

        then:
        linkedList.size() == 2
        linkedList.get(1) == firstItem
        linkedList.get(2) == secondItem
    }

    def "indexing starts with 1, trying to fetch 0 element will result in exception"() {
        given:
        def linkedList = new MyLinkedList()

        when:
        linkedList.get(0)

        then:
        thrown IllegalArgumentException
    }

    def "trying to get item of higher index than the amount of items will result in exception"() {
        given:
        def linkedList = new MyLinkedList()
        linkedList.add("irrelevant")

        when:
        linkedList.get(2)

        then:
        thrown IllegalArgumentException
    }

    def "list has the capability of reversing the order of elements"() {
        given:
        def firstItem = "first"
        def secondItem = "second"
        def thirdItem = "third"

        def linkedList = new MyLinkedList()
        linkedList.add(firstItem)
        linkedList.add(secondItem)
        linkedList.add(thirdItem)

        when:
        linkedList.iterativeReverse()

        then:
        linkedList.get(1) == thirdItem
        linkedList.get(2) == secondItem
        linkedList.get(3) == firstItem
    }
    
}
