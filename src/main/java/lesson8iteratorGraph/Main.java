package lesson8iteratorGraph;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Iterator<Character> iterator = graph.iterator();

        while (iterator.hasNext()) {
            iterator.next();
        }
    }
}
