package lab2_1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List403Impl list = new List403Impl();

        for (int i = 0; i <= 10; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(101);
            list.add(randomNumber);
        }

        list.printer();
        System.out.println("Размер массива : " + list.size());

        list.add(34, 4);
        list.printer();

        list.remove(4);
        list.printer();

        System.out.println("Удаленный элемент " + list.get(4));

        list.sort(true);
        System.out.println("Массив по возрастанию");
        list.printer();

        list.sort(false);
        System.out.println("Массив по убыванию");
        list.printer();


    }
}
