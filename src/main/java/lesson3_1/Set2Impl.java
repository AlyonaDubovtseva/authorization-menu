package lesson3_1;

import java.util.Arrays;

public class Set2Impl<T> implements Set2<T> {
    private Object [] values;
    private int size;

    public Set2Impl() {
        this.values = new Object[10];
        this.size = 0;
    }
    public int size() {
        return size;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void add(T element) {
        if(!contains(element)) {
            if (size >= values.length) {
                grow();
            }
            values[size++] = element;
        }
    }
    private void grow() {
        Object [] newValues = new Object[(int)(size * 1.5)];
        for(int i = 0; i < size; i++) {
            newValues[i] = values[i];
        }
        values = newValues;

    }

    public T[] getAll() {
        T[] result = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = (T) values[i];
        }
        return result;
    }

    public T remove(T element)  {
        for (int i = 0; i < size; i++) {
            if(values[i].equals(element)) {
                T removedValue = (T) values[i];

                for (int j = i; j < size - 1; j++) {
                    values[j] = values[j + 1];
                }
                size--;
                return removedValue;
            }
        }
        throw new NoSuchElementException("Элемент не найден!");
    }

    @Override
    public String toString() {
        return Arrays.toString(getAll());
    }
}
