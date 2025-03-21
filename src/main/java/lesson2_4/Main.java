package lesson2_4;

public class Main {
    public static void main(String[] args) {
        Test();
    }
    public static void Test() {
        SetImpl<Integer> set = new SetImpl<>();

        set.add(2);
        set.add(3);
        set.add(4);
        System.out.println(set);
        set.add(2);
        System.out.println(set);


        System.out.println(set.contains(2));
    }
}
