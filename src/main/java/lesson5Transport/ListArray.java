package lesson5Transport;

import lesson1.IndexOutOfRangeException;

import java.util.Comparator;

public interface ListArray<T> {//переменная для типа данных
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
        void add(T element, int position) throws IndexOutOfRangeException;

        /**
         * Удаляет элемент из списка с позиции
         *
         * @param position
         * @return
         */
        T remove(int position) throws IndexOutOfRangeException;

        T get(int position) throws IndexOutOfRangeException;//из-за null Integer

        void sort(Comparator<T> comparator);

    }

