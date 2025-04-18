package lesson3_1;

public interface Set2<T> {
    int size();

    T get(int index);

    boolean contains(T element);

    void add(T element);

    T[] getAll();

    T remove(T element) ;
}
