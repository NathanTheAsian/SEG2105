public interface MyStack {
    void push();
    void pop();
    void isEmpty();
}

class LinkedList implements MyStack {

    class Node<E> {
        E element;
        E next;
        E prev;

        Node(element, next, prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;

        }
    }

    LinkedList() {
        Node head = new Node(null, null, null);
    }

}