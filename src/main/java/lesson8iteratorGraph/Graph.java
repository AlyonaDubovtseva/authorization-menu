package lesson8iteratorGraph;

import java.util.*;

public class Graph {
    private Map<Character, Set<Character>> graph;

    public Graph() {
        graph = new LinkedHashMap<>();

        graph.put('d', null);
        graph.put('a', new HashSet<>(Set.of('d', 'c')));
        graph.put('f', new HashSet<>(Set.of('d')));
        graph.put('g', new HashSet<>(Set.of('d', 'c', 'f')));
        graph.put('c', null);
        graph.put('b', new HashSet<>(Set.of('f','g','a','c')));
    }

    public Iterator<Character> iterator() {
        List<Character> sorted = sort();
        return new GraphIterator(sorted);
    }


    public List<Character> sort() {
        Map<Character, Integer> degree = new HashMap<>();

        for(Character ch : graph.keySet()) {
            degree.put(ch, 0);
        }
        for(Set<Character> vhodrebr : graph.values()) {
            if(vhodrebr != null) {
                for(Character rebr : vhodrebr) {
                    if(!degree.containsKey(rebr)) {
                        degree.put(rebr, degree.get(rebr) + 1);
                    }
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry : degree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        List<Character> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            Character current = queue.poll();
            result.add(current);

            for(Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
                Set<Character> rebra = entry.getValue();
                if(rebra != null && rebra.contains(current)) {
                    rebra.remove(current);
                    degree.put(entry.getKey(), degree.get(entry.getKey()) - 1);
                    if (degree.get(entry.getKey()) == 0) {
                        queue.add(entry.getKey());
                    }
                }
            }
        }
        if (result.size() != graph.size()) {
            throw new RuntimeException("Граф содержит цикл. Сортировка невозможна.");
        }

        return result;
    }
}
