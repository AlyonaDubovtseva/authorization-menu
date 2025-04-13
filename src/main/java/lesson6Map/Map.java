package lesson6Map;

import lesson2_3.LinkedList;
import lesson2_4.Set;

public interface Map<K, V> {
    void put(K key, V value);

    V get(K kye);

    Set<K> keySet();

    LinkedList<V> values();

    int size();

    boolean containsKeys(K kye);

    boolean isEmpty();

    boolean containsValue(V value);

    V remove(K key);

    void clear();

    interface Entry<K, V> {
        void setKey(K key);
        void setValue(V value);
        K getKey();
        V getValue();
    }



}
