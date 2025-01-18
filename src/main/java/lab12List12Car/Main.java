package lab12List12Car;

public class Main {
    public static void main(String[] args) {
        ListDirection list = new ListDirection();

        list.add(new Car("Toyota", 150, 20000));
        list.add(new Car("BMW", 250, 50000));
        list.add(new Car("Honda", 120, 18000));
        list.add(new Car("Audi", 300, 60000));

        System.out.println("Список машин:");
        list.print();

        list.addOnPosition(2, new Car("Tesla", 360, 100000));
        System.out.println("\nПосле добавления на позицию 3: " );
        list.print();

        list.sort();

        System.out.println("\nОтсортированный список по мощности автомобиля:");
        list.print();
    }
}

