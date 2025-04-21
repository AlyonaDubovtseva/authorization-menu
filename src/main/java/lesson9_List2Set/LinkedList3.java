package lesson9_List2Set;

import lab18.Function;
import lesson1.IndexOutOfRangeException;
import lesson3_1.Set2;

public interface LinkedList3<T> {
    /**
     * Метод добавляет в конец списка
     *
     * @param element
     */
    void add(T element);

    /**
     * Метод добавляет в указанную позицию
     *
     * @param element
     */
    void add(T element, int position) throws IndexOutOfRangeException ;

    int size();

    T remove(int position) throws IndexOutOfRangeException;

    T get(int position) throws IndexOutOfRangeException;//из-за null Integer


}
