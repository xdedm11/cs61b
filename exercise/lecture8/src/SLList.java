public class SLList<Item> implements List61B<Item> {
    private class IntNode {
        public Item item;
        public IntNode next;

        public IntNode(Item i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /**
     * The first item(if it exists) is at sentinel.next
     */
    private IntNode sentinel;
    private int size;

    /**
     * Create an empty SLList.
     */
    public SLList() {
        sentinel = new IntNode(null, null);
        size = 0;
    }

    public SLList(Item x) {
        sentinel = new IntNode(null, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /**
     * Adds x to the front of the list.
     */
    @Override
    public void addFirst(Item x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    /**
     * Return the first item in the list.
     */
    @Override
    public Item getFirst() {
        return sentinel.next.item;
    }

    @Override
    public Item getLast() {
        return null;
    }

    @Override
    public Item removeLast() {
        return null;
    }

    @Override
    public Item get(int i) {
        return null;
    }

    @Override
    public void insert(Item x, int position) {
        if (sentinel.next == null || position == 0) {
            addFirst(x);
            return;
        }
        IntNode currentNode = sentinel.next.next;
        while (position > 1 && currentNode.next != null) {
            position--;
            currentNode = currentNode.next;
        }
        IntNode newNode = new IntNode(x, currentNode.next);
        currentNode.next = newNode;
    }

    /**
     * Adds an item to the end of the list.
     */
    @Override
    public void addLast(Item x) {
        size++;
        IntNode p = sentinel;
        /** Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        System.out.println("print of SLList");
        for (IntNode p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }
}
