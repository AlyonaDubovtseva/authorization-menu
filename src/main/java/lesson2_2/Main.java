package lesson2_2;

public class Main {
    public static void main(String[] args) {
        addTest();
    }

    public static void  addTest() {
        List2Impl<String> list = new List2Impl<>(); // тут во второй можно не писать интеджер

        list.add("");
        list.add("");
        list.add("");

        System.out.println(list);

    }
}
