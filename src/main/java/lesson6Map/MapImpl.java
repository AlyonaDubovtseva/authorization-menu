package lesson6Map;

import lesson2_3.LinkedList;
import lesson2_3.LinkedListImpl;
import lesson2_4.Set;
import lesson2_4.SetImpl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MapImpl<K, V> implements Map<K, V>, Iterable<Map.Entry<K, V>> {
    public Node<K, V>[] array;
    private int size;

    public class Node<K, V> {
        Entry<K, V> value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.value = new EntryImpl<>(key, value);
        }
    }
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new MapIterator();
    }
    public class MapIterator implements Iterator<Map.Entry<K, V>> {
        private int currentIndex;
        private Node<K, V> currentNode = null;

        public MapIterator() {
            goToNext();
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Entry<K, V> result = currentNode.value;
            currentNode = currentNode.next;

            if (currentNode == null) {
                currentIndex++;
                goToNext();
            }

            return result;
        }

        private void goToNext() {
            while (currentIndex < array.length && array[currentIndex] == null) {
                currentIndex++;
            }

            if (currentIndex < array.length) {
                currentNode = array[currentIndex];
            } else {
                currentNode = null;
            }
        }
    }

    class EntryImpl<K, V>  implements Entry<K, V> {

        private K key;
        private V value;

        public EntryImpl(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }


    public MapImpl() {
        array = new Node[16];
    }
    @Override
    public void put(K key, V value) {

        int index = Math.abs(key.hashCode() % 16);
        Node<K,V> temp = new Node<>(key,value);

        if (array[index] == null) {
            array[index] = temp;
        } else {
            Node current = array[index];
            while(current != null) {
                if(current.value.getKey().equals(key)) {
                    current.value.setValue(value);
                    return;
                }
                current = current.next;
            }
            current.next = temp;
        }

        size++;
    }

    @Override
    public V get(K key) {

        int index = Math.abs(key.hashCode() % 16);
        if (array[index] == null) {
            return null;
        }

        Node<K,V> current = array[index];
        while(current != null) {

            if(current.value.getKey().equals(key)) {
                return current.value.getValue();
            }
            current = current.next;
        }

        return null;
    }

    @Override
    public Set<K> keySet() {

        Set<K> keys = new SetImpl<>();

        for (int i = 0; i < array.length; i++) {
            Node<K, V> current = array[i];
            while(current != null) {
                keys.add(current.value.getKey());
                current = current.next;
            }
        }

        return keys;
    }

    @Override
    public LinkedList<V> values() {
        LinkedList<V> values = new LinkedListImpl<>();

        for (int i = 0; i < array.length; i++) {
            Node<K, V> current = array[i];
            while(current != null) {
                values.add(current.value.getValue());
                current = current.next;
            }
        }

        return values;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKeys(K key) {

        int index = Math.abs(key.hashCode() % 16);
        Node<K, V> current = array[index];

        if (array[index] == null) {
            return false;
        }

        while(current != null) {
            if(current.value.getKey().equals(key)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean containsValue(V value) {

        if(value == null) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            Node<K, V> current = array[i];
            while (current != null) {
                if(current.value.getValue().equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V remove(K key) {

        int index = Math.abs(key.hashCode() % 16);
        Node<K,V> current = array[index];
        Node<K,V> prev = null;

        while(current != null) {
            if (current.value.getKey().equals(key) && current.value != null) {
                V removeValue = current.value.getValue();
                if (prev == null) {
                    array[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return removeValue;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i <array.length ; i++) {
            array[i] = null;
        }
        size = 0;
    }
}
