public class LinkedListDeque<Item> {
    private class IntNode {
        public Item item;
        public IntNode next;
        public IntNode last;

        public IntNode(Item i, IntNode n, IntNode l) {
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

    public LinkedListDeque(Item x) {
        firstsentinel = new IntNode(null, null, null);
        lastsentinel = new IntNode(null, null, null);
        firstsentinel.next = new IntNode(x, lastsentinel, firstsentinel);
        lastsentinel.last = firstsentinel.next;
        size = 1;
    }

    /**
     * Adds x to the front of the list.
     */
    public void addFirst(Item x) {
        IntNode temp = firstsentinel.next;
        firstsentinel.next = new IntNode(x, temp, firstsentinel);
        temp.last = firstsentinel.next;
        size++;
    }

    /**
     * Adds an item to the end of the list.
     */
    public void addLast(Item x) {
        IntNode temp = lastsentinel.last;
        lastsentinel.last = new IntNode(x, lastsentinel, temp);
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

    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Item value = firstsentinel.next.item;
        IntNode temp = firstsentinel.next.next;
        firstsentinel.next = temp;
        temp.last = firstsentinel;
        size--;
        return value;
    }

    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        Item value = lastsentinel.last.item;
        IntNode temp = lastsentinel.last.last;
        lastsentinel.last = temp;
        temp.next = lastsentinel;
        size--;
        return value;
    }

    public Item get(int i) {
        if (i >= size || i < 0) {
            return null;
        }
        IntNode p = firstsentinel.next;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        return p.item;
    }

    public Item getRecursive(int i) {
        if (i >= size || i < 0) {
            return null;
        }
        return getRecursiveHelper(firstsentinel.next, i);
    }

    private Item getRecursiveHelper(IntNode node, int i) {
        if (i == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, i - 1);
    }

}
