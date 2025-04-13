package lesson4;

public interface Set3<T> {

        int size();

        boolean contains(T element);

        void add(T element);

        T[] getAll(T [] c);

        T remove(T element) ;
}

