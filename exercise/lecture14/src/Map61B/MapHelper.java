package Map61B;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

//MapHelper testGet()
public class MapHelper {
    public static <K, V> V get(Map61B<K, V> sim, K key) {
        if (sim.containsKey(key)) {
            return sim.get(key);
        }
        return null;
    }

    public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map) {
        List<K> keylist = map.keys();
        K largest = keylist.get(0);
        for (K key : keylist) {
            if (key.compareTo(largest) > 0) {
                largest = key;
            }
        }
        return largest;
    }

    @Test
    public void testGet() {
        Map61B<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        Integer actual = MapHelper.get(m, "fish");
        Integer expected = 9;
        assertEquals(expected, actual);

        assertEquals(null, MapHelper.get(m, "abc"));
    }

    @Test
    public void testMaxKey() {
        Map61B<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        String actual = MapHelper.maxKey(m);
        String expected = "house";
        assertEquals(expected, actual);
    }
}
