package lesson3_2;

import lesson1.List403Impl;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Test();
    }

    public static void Test() {

        List3Impl<Long> list = new List3Impl<>();
        long startTime = System.nanoTime();
        for (int i = 0; i <= 100000; i++) {
            Random random = new Random();
            long randomNumber = random.nextLong(1000000000L);
            list.add(randomNumber);
        }
        long endTime = System.nanoTime();
        long finishTime = endTime - startTime;
        System.out.println("Время добавления элементов в массив: " + finishTime);

        long startTime2 = System.nanoTime();
        LinkedList2Impl<Long> linkedList2 = new LinkedList2Impl<Long>();
        for (int i = 0; i <= 100000; i++) {
            Random random = new Random();
            long randomNumber = random.nextLong(1000000000L);
            linkedList2.add(randomNumber);
        }
        long endTime2 = System.nanoTime();
        long finishTime2 = endTime2 - startTime2;
        System.out.println("Время добавления элементов в двусвязный список: " + finishTime2);

        long startTime3 = System.nanoTime();
        for (int i = 0; i <= 10000; i++) {
            Random random = new Random();
            long randomIndex = random.nextLong(100000);
            list.add(randomIndex);
        }
        long endTime3 = System.nanoTime();
        long finishTime3 = endTime3 - startTime3;
        System.out.println("Время удаления элементов из массива: " + finishTime3);

        long startTime4 = System.nanoTime();
        for (int i = 0; i <= 10000; i++) {
            Random random = new Random();
            long randomIndex = random.nextLong(100000);
            linkedList2.add(randomIndex);
        }
        long endTime4 = System.nanoTime();
        long finishTime4 = endTime4 - startTime4;
        System.out.println("Время удаления элементов из двусвязного списка: : " + finishTime4);


    }
}
