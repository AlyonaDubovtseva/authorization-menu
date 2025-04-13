package lesson4;

import lesson2_4.NoSuchElementException;
import lesson2_4.Set;

import java.lang.reflect.Array;

public class Set3Impl<T> implements Set3<T> {
    private Object [] values;
    private int size;

    public Set3Impl() {
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

    public T[] getAll(T[] c) {
        T[] result = (T[])Array.newInstance(c.getClass().componentType(), size);
        for (int i = 0; i < size; i++) {
            result[i] = (T) values[i];
        }
        System.out.println(result.getClass());
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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(values[i].toString()).append(" ");
        }
        return stringBuilder.toString();
    }

}
