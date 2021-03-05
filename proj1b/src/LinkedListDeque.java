public class LinkedListDeque<Item> implements Deque<Item> {
    private class IntNode {
        private Item item;
        private IntNode next;
        private IntNode last;

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
    @Override
    public void addFirst(Item item) {
        IntNode temp = firstsentinel.next;
        firstsentinel.next = new IntNode(item, temp, firstsentinel);
        temp.last = firstsentinel.next;
        size++;
    }

    /**
     * Adds an item to the end of the list.
     */
    @Override
    public void addLast(Item item) {
        IntNode temp = lastsentinel.last;
        lastsentinel.last = new IntNode(item, lastsentinel, temp);
        temp.next = lastsentinel.last;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (IntNode p = firstsentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    @Override
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

    @Override
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

    @Override
    public Item get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        IntNode p = firstsentinel.next;
        for (int j = 0; j < index; j++) {
            p = p.next;
        }
        return p.item;
    }

    public Item getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return getRecursiveHelper(firstsentinel.next, index);
    }

    private Item getRecursiveHelper(IntNode node, int i) {
        if (i == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, i - 1);
    }

}
