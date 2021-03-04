public class ArrayDeque<Item> implements Deque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    private int plusposition(int i) {
        if (i == items.length - 1) {
            i = 0;
        } else {
            i++;
        }
        return i;
    }

    private int minusposition(int i) {
        if (i == 0) {
            i = items.length - 1;
        } else {
            i--;
        }
        return i;
    }

    private void resize(int capacity) {
        if (isFull()) {
            Item[] a = (Item[]) new Object[capacity];
            System.arraycopy(items, 0, a, 0, nextFirst + 1);
            System.arraycopy(items, nextLast + 1, a, capacity - size + nextLast + 1, size - nextLast - 1);
            items = a;
        }
    }

    @Override
    public void addFirst(Item x) {
        if (isFull()) {
            resize(size * 2);
        }
        items[nextFirst] = x;
        nextFirst = minusposition(nextFirst);
        size++;
    }

    @Override
    public void addLast(Item x) {
        if (isFull()) {
            resize(size * 2);
        }
        items[nextLast] = x;
        nextLast = plusposition(nextLast);
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == items.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = nextFirst + 1, j = 0; j <= size; i++, j++) {
            if (i == (items.length)) {
                i = 0;
            }
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        int position = plusposition(nextFirst);
        Item value = items[position];
        items[position] = null;
        nextFirst = position;
        size--;
        return value;
    }

    @Override
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        int position = minusposition(nextLast);
        Item value = items[position];
        items[position] = null;
        nextLast = position;
        size--;
        return value;
    }

    @Override
    public Item get(int i) {
        return items[i];
    }
}
