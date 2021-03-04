public class LinkedListDeque<T> {
    private class IntNode {
        private T item;
        private IntNode next;
        private IntNode last;

        public IntNode(T i, IntNode n, IntNode l) {
            item = i;
            next = n;
            last = l;
        }
    }

    private IntNode firstsentinel;
    private IntNode lastsentinel;
    private int size;

    /**
     * Create an empty SLList.
     */
    public LinkedListDeque() {
        firstsentinel = new IntNode(null, null, null);
        lastsentinel = new IntNode(null, null, firstsentinel);
        firstsentinel.next = lastsentinel;
        size = 0;
    }

    public LinkedListDeque(T x) {
        firstsentinel = new IntNode(null, null, null);
        lastsentinel = new IntNode(null, null, null);
        firstsentinel.next = new IntNode(x, lastsentinel, firstsentinel);
        lastsentinel.last = firstsentinel.next;
        size = 1;
    }

    /**
     * Adds x to the front of the list.
     */
    public void addFirst(T item) {
        IntNode temp = firstsentinel.next;
        firstsentinel.next = new IntNode(item, temp, firstsentinel);
        temp.last = firstsentinel.next;
        size++;
    }

    /**
     * Adds an item to the end of the list.
     */
    public void addLast(T item) {
        IntNode temp = lastsentinel.last;
        lastsentinel.last = new IntNode(item, lastsentinel, temp);
        temp.next = lastsentinel.last;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (IntNode p = firstsentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T value = firstsentinel.next.item;
        IntNode temp = firstsentinel.next.next;
        firstsentinel.next = temp;
        temp.last = firstsentinel;
        size--;
        return value;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T value = lastsentinel.last.item;
        IntNode temp = lastsentinel.last.last;
        lastsentinel.last = temp;
        temp.next = lastsentinel;
        size--;
        return value;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        IntNode p = firstsentinel.next;
        for (int j = 0; j < index; j++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return getRecursiveHelper(firstsentinel.next, index);
    }

    private T getRecursiveHelper(IntNode node, int i) {
        if (i == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, i - 1);
    }

}
