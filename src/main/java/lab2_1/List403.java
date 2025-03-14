package lab2_1;

public interface List403  {
    /**
     * Метод добавляет в конец списка
     * @param element
     */
    void add(Integer element);

    /**
     * Метод добавляет в указанную позицию
     * @param element
     */
    void add(Integer element, int position) throws IndexOutOfRangeException;

    /**
     * Удаляет элемент из списка с позиции
     * @param position
     * @return
     */
    Integer remove(int position) throws IndexOutOfRangeException;

    int size();

    Integer get(int position) throws IndexOutOfRangeException;//из-за null Integer

    /**
     * Сортировка списка (asc = true; по возрастанию)
     */
    void sort(boolean asc);

}
