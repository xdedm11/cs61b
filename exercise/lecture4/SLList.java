import org.graalvm.compiler.core.common.util.IntList;

/** An SLlist is a list of integers, which hides the terrible truth of the nakedness within. */
public class SLList {
    /** nested class is subordinate to another class.
     * make it private if other classes never use it.
     * add static if IntNode never uses any detail of SLList, which could save 
     * (Never Look outwards)
    */
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    
    /** The first item(if it exists) is at sentinel.next */
    private IntNode sentinel;
    private int size;

    /** Create an empty SLList. */
    public SLList() {
        sentinel = new IntNode(-1, null);
        size = 0;
    }
    
    public SLList(int x) {
        sentinel = new IntNode(-1, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    /** Return the first item in the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        size++;         
        IntNode p = sentinel;
        /** Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null); 
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
