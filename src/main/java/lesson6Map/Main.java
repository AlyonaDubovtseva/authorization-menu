package lesson6Map;

public class Main {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        Map<Integer, String> map = new MapImpl<>();

        System.out.println(map.isEmpty());

        map.put(1,"Привет");
        map.put(2,"группа");
        map.put(3,"11-403");
        map.put(4,"Пока");

        System.out.println("Размер: " + map.size());
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));

        System.out.println(map.containsKeys(3));
        System.out.println(map.containsValue("hi"));

        System.out.println("Удаленный элемент: " + map.remove(2));

        System.out.println(map.isEmpty());

        System.out.println(map.keySet());
        System.out.println(map.values());

        map.clear();
        System.out.println(map.isEmpty());

    }
}
