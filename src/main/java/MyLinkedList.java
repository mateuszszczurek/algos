public class MyLinkedList<T> {

    private final Node<T> END_OF_LIST = null;

    private int size;
    private Node<T> head;

    public void add(T item) {
        size++;

        if (head == null) {
            head = new Node(item);
            return;
        }

        Node<T> whichShouldBeCreated = head;

        while (whichShouldBeCreated.next != END_OF_LIST) {
            whichShouldBeCreated = whichShouldBeCreated.next;
        }

        whichShouldBeCreated.next = new Node(item);
    }

    public int size() {
        return size;
    }

    public T get(int index) {

        checkIndexConstraint(index);

        int itemNumber = 1;
        Node<T> currentItem = head;

        while (itemNumber < index) {

            if (currentItem.next == END_OF_LIST) {
                throw new IllegalArgumentException();
            }

            currentItem = currentItem.next;
            itemNumber++;

        }

        return currentItem.value;

    }

    private void checkIndexConstraint(int index) {
        if(index < 1 || index > size) {
            throw new IllegalArgumentException();
        }
    }

    public void iterativeReverse() {
        if(oneElementList()) {
            return;
        }

        Node<T> prev = END_OF_LIST;
        Node<T> current = head;

        for(int i = 1; i <= size; i++) {
            Node<T> oldNext = current.next;
            current.next = prev;
            prev = current;
            current = oldNext;
        }

        head = prev;

    }

    private boolean oneElementList() {
        return head.next == END_OF_LIST;
    }

    public void anotherRecursiveReverse() {
        head = anotherRecursiveReverse(head);
    }

    private Node<T> anotherRecursiveReverse(Node<T> node) {
        if(node == null || node.next == null) {
            return node;
        }

        Node<T> remaining = anotherRecursiveReverse(node.next);
        node.next.next = node;
        node.next = null;
        return remaining;
    }

    public void recursiveReverse() {
        recursiveReverse(null, head);
    }

    private void recursiveReverse(Node<T> previous, Node<T> current) {
        if(current == END_OF_LIST) {
            return;
        }

        if(current.next == null) {
            head = current;
        }

        Node<T> next = current.next;
        current.next = previous;

        recursiveReverse(current, next);
    }

    private class Node<T> {

        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

}
