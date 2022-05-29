package pl.shonsu.tests;

public class SingleLinkedList<E> {

    private Node<E> first;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        Node(E element) {
            this.element = element;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int size = 0;
        Node<E> currentNode = first;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    public E get(int index) {
        if (isEmpty() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index);
        }

        Node<E> currentNode = first;
        int currentIndex = index;
        while (currentIndex > 0) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException("Index " + index);
            }
            currentNode = currentNode.next;
            currentIndex--;
        }

        return currentNode.element;
    }

    private static class NodePair<E> {
        private final Node<E> previous;
        private final Node<E> current;

        private NodePair(Node<E> previous, Node<E> current) {
            this.previous = previous;
            this.current = current;
        }
    }

    private NodePair<E> getNodeWithPrevious(int index) {
        if (isEmpty() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index);
        }

        Node<E> previousNode = null;
        Node<E> currentNode = first;
        int currentIndex = index;
        while (currentIndex > 0) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException("Index " + index);
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
            currentIndex--;
        }

        return new NodePair<>(previousNode, currentNode);
    }
    public boolean add(int index, E element) {
        if (first == null && index == 0) {
            first = new Node<>(element);
            return true;
        }

        NodePair<E> pair = getNodeWithPrevious(index);
        Node<E> previousNode = pair.previous;
        Node<E> nodeAtIndex = pair.current;

        // adding at the beginning of the list
        if (previousNode == null) {
            first = new Node<>(element);
            first.next = nodeAtIndex;
            return true;
        }

        Node<E> newNode = new Node<>(element);
        newNode.next = nodeAtIndex;
        previousNode.next = newNode;
        return true;
    }
    public E remove(int index) {
        NodePair<E> pair = getNodeWithPrevious(index);
        Node<E> previousNode = pair.previous;
        Node<E> nodeToRemove = pair.current;
        E removedElement = nodeToRemove.element;

        // removing first node
        if (previousNode == null) {
            first = nodeToRemove.next;
            return removedElement;
        }

        previousNode.next = nodeToRemove.next;
        return removedElement;
    }
}