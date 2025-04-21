package lesson8iteratorGraph;

import java.util.Iterator;
import java.util.List;

public class GraphIterator implements Iterator<Character> {
    private final Iterator<Character> iterator;

    public GraphIterator(List<Character> sortedVertices) {
        this.iterator = sortedVertices.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Character next() {
        Character ver = iterator.next();
        System.out.println(ver);
        return ver;
    }
}
