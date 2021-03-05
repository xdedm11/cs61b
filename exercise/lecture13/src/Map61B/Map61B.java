package Map61B;
//Mpa61B keys()
import java.util.List;

public interface Map61B<K, V> {
    boolean containsKey(K key);
    V get(K key);
    int size();
    void put(K key, V value);
    /** Return a list of the keys in this map. */
    List<K> keys();
}
