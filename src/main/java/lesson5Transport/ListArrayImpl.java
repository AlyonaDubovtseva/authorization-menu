package lesson5Transport;

import lesson1.IndexOutOfRangeException;
import lesson2_2.List2;

import java.util.Comparator;

public class ListArrayImpl<T> implements List2<T> {
    private Object [] values;
    private int size;

    public ListArrayImpl() {
        this.values = new Object[10];
        this.size = 0;
    }

    public void add(T element) {
        if (size >= values.length) {
            grow();
        }
        values[size++] = element;

    }

    public void add(T element, int position) throws IndexOutOfRangeException {
        if (position > size || position < 0) {
            throw new IndexOutOfRangeException("Выход за массив");
        }
        for (int i = size; i != position; i--) {
            values[i] = values[i - 1];
        }
        values[position] = element;
        size++;

    }

    public T remove(int position) throws IndexOutOfRangeException {
        if (position > size - 1 || position < 0) {
            throw new IndexOutOfRangeException("Выход за массив");
        }
        T temp = (T)values[position];
        for (int i = position; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        size--;
        return temp;
    }

    public int size() {
        return size;
    }

    public T get(int position) throws IndexOutOfRangeException {
        if (position > size - 1 || position < 0) {
            throw new IndexOutOfRangeException("Выход за массив");
        }
        return (T)values[position];
    }

    private void grow() {
        Object [] newValues = new Object[(int)(size * 1.5)];
        for(int i = 0; i < size; i++) {
            newValues[i] = values[i];
        }
        values = newValues;

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(values[i]).append("\n");
        }
        return stringBuilder.toString();
    }

    public void sort(Comparator<T> comparator) {
        for (int i = 0; i < size - 1; ++i) {
            for (int j = 0; j < size - i - 1; ++j) {
                T a = (T) values[j];
                T b = (T) values[j + 1];
                if (comparator.compare(a, b) > 0) {
                    values[j] = b;
                    values[j + 1] = a;
                }
            }
        }

    }
}
