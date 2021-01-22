/** An SLlist is a list of integers, which hides the terrible truth of the nakedness within. */
public class SLList<LochNess> {
    /** nested class is subordinate to another class.
     * make it private if other classes never use it.
     * add static if IntNode never uses any detail of SLList, which could save 
     * (Never Look outwards)
    */
    private class StuffNode {
        public LochNess item;
        public StuffNode next;

        public StuffNode(LochNess i, StuffNode n) {
            item = i;
            next = n;
        }
    }
    
    /** The first item(if it exists) is at sentinel.next */
    private StuffNode sentinel;
    private int size;
    
    public SLList(LochNess x) {
        sentinel = new StuffNode(null, null);
        sentinel.next = new StuffNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(LochNess x) {
        sentinel.next = new StuffNode(x, sentinel.next);
        size++;
    }

    /** Return the first item in the list. */
    public LochNess getFirst() {
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(LochNess x) {
        size++;         
        StuffNode p = sentinel;
        /** Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new StuffNode(x, null); 
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList L = new SLList();
        // L.addFirst(10);
        // L.addFirst(5);
        L.addLast(20);
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }
}
