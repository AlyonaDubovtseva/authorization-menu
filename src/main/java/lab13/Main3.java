package lab13;
//Почему подходит 3-й вариант (Main3)?
//Повторное использование компаратора:
//
//В третьем варианте компаратор вынесен
// в отдельный класс (или вложенный класс), что позволяет его
// использовать в других частях программы, если потребуется
// сортировать другие массивы объектов Apple.
//Это удобно и соответствует принципу переиспользования кода.
//Читабельность и структура:
//
//Отдельный компаратор делает код читаемым и организованным.
//Такой подход хорошо подходит для больших проектов.
//Пример реализации для ДЗ: Если мы будем сортировать массивы
// других объектов (например, Car, Book, и т.д.), просто создаём
// новые классы-компараторы.

public class Main3 {
    public static void main(String[] args) {
        Apple[] apples = {
                new Apple(120, "Голд"),
                new Apple(110, "Семеринка"),
                new Apple(150, "Фуджи")
        };

        AppleComparator comparator = new AppleComparator();
        ArrayUtils.sort(apples, comparator);

        for (int i = 0; i < apples.length; i++) {
            System.out.println(apples[i].getPrice() + " " + apples[i].getKind());
        }
    }

    private static class AppleComparator implements CanCompare {
        @Override
        public int compare(Object var1, Object var2) {
            return ((Apple) var1).getPrice() - ((Apple) var2).getPrice();
        }
    }
}
