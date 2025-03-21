package lesson2_1;

import lesson1.IndexOutOfRangeException;

public interface List {
    /**
     * Метод добавляет в конец списка
     *
     * @param element
     */
    void add(Object element);

    /**
     * Метод добавляет в указанную позицию
     *
     * @param element
     */
    void add(Object element, int position) throws IndexOutOfRangeException;

    /**
     * Удаляет элемент из списка с позиции
     *
     * @param position
     * @return
     */
    Object remove(int position) throws IndexOutOfRangeException;

    int size();

    Object get(int position) throws IndexOutOfRangeException;//из-за null Integer

}


