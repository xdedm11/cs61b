package Map61B;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayMap<K, V> implements Map61B<K, V>, Iterable<K> {
    private K[] keys;
    private V[] values;
    int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    public Iterator<K> iterator() {
        /*
        List<K> keylist = keys();
        return keylist.iterator();
         */
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator<K> {
        private int wizardPosition;

        public KeyIterator() {
            wizardPosition = 0;
        }

        public boolean hasNext() {
            return wizardPosition < size;
        }

        public K next() {
            K returnValue = keys[wizardPosition];
            wizardPosition++;
            return returnValue;
        }
    }

    private int keyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public boolean containsKey(K key) {
        int index = keyIndex(key);
        return index > -1;
    }

    public void put(K key, V value) {
        int index = keyIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
//        keys[index] = key;redundant
        values[index] = value;
    }

    public V get(K key) {
        int index = keyIndex(key);
        if (index == -1) {
            throw new IllegalArgumentException("The key provided " + key + " was not in ArrayMap.");
        }
        return values[index];
    }

    public int size() {
        return size;
    }

    public List<K> keys() {
        List<K> keylist = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            keylist.add(keys[i]);
        }
        return keylist;
    }

    @Test
    public void test() {
        ArrayMap<Integer, Integer> am = new ArrayMap<Integer, Integer>();
        am.put(2, 3);
        int expected = 3;
        assertEquals((Integer) expected, am.get(2));
        /*Ambiguous method call.
        Both assertEquals(Object,Object)in Assert and assertEquals(long,long)in Assert match*/
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> map = new ArrayMap<String, Integer>();
        map.put("horse", 3);
        map.put("fish", 9);
        map.put("house", 10);
        System.out.println(map.get("horse"));
    }
}