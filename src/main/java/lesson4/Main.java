package lesson4;

public class Main {
    public static void main(String[] args) {
        Test();
    }
    public static void Test() {
        Set3Impl<Fruit> set = new Set3Impl<>();
        set.add(new Fruit("Apple", 5));
        set.add(new Fruit("Peach", 6));
        set.add(new Fruit("Orange", 7));
        set.add(new Fruit("Apple", 5));

        Fruit a[] = set.getAll(new Fruit[0]);
        for(Fruit i : a) {
            System.out.println(i);
        }
    }
}
