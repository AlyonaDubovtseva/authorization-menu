package lesson2_3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Test();
    }
    public static void Test() {
        LinkedList<Integer> linkedList = new LinkedListImpl<>();

        for (int i = 0; i <= 5; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(101);
            linkedList.add(randomNumber);
        }
        System.out.println("Список: " + linkedList);

        linkedList.add(11, 1);
        System.out.println("Список: " + linkedList);

        System.out.println("Размер списка: " + linkedList.size());

        System.out.println("Удаленный элемент: "  + linkedList.remove(7));
        System.out.println("Список: " + linkedList);
        System.out.println("Элемент на первой позиции: " + linkedList.get(1));
    }
}
