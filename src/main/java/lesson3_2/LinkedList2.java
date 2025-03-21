package lesson3_2;

import lesson1.IndexOutOfRangeException;

public interface LinkedList2<T> {
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

    /**
     * Удаляет элемент из списка с позиции
     *
     * @param position
     * @return
     */
    int size();

    T remove(int position) throws IndexOutOfRangeException;

    T get(int position) throws IndexOutOfRangeException;//из-за null Integer

}
