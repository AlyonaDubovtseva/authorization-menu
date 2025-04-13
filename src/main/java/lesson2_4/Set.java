package lesson2_4;

public interface Set<T> {

        int size();

        boolean contains(T element);

        void add(T element);

        T[] getAll(T [] c);

        T remove(T element) ;
}

