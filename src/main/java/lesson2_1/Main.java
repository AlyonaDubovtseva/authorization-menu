package lesson2_1;

public class Main {
    public static void main(String[] args) {
    addTest();
    }

    public static void  addTest() {
        ListImp list = new ListImp();

        list.add(1);
        list.add("2");
        list.add(3);

        System.out.println(list);

    }
}
