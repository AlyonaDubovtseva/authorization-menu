package lesson7IteratorMenu;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Menu2 {
    private String[] dishes;

    public Menu2() {
        dishes = new String[] {"Рыба", "Мясо", "Картошка", "Макароны"};
    }

    public Iterator<String> iterator() {
        System.out.println("get iterator");
        return new MenuIterator();
    }

    class MenuIterator implements Iterator<String> {
        private int currentIndex = -1;

        public boolean hasNext() {
            System.out.println("hasNext " + currentIndex);
            return currentIndex < dishes.length - 1;
        }

        public String next() {
            System.out.println("next " + currentIndex);
            if (currentIndex == dishes.length - 1) {
                throw new NoSuchElementException();
            }
            return dishes[++currentIndex];
        }
    }

}
