package lesson3_1;

public class Main {
    public static void main(String[] args) {
        Test();
    }
    public static void Test() {
        Auto car1 = new Auto("Toyota", 250, 2020, "Black");
        Auto car2 = new Auto("Honda", 230, 2019, "White");
        Auto car3 = new Auto("Toyota", 270, 2021, "Black");
        Auto car4 = new Auto("Toyota", 290, 2020, "Red");

        Set2Impl<Auto> set = new Set2Impl<Auto>();

        set.add(car1);
        set.add(car2);
        set.add(car3);
        set.add(car4);
        System.out.println(set);
        set.add(new Auto("Toyota", 210, 2020, "Black"));
        System.out.println(set);
        set.get(1);

    }

}
