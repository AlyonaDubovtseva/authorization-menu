package lab18;
//классы обертки:

//extends Number

// Integer - int (private final int value)
// Double - double,
// Long - long,
// Boolean - boolean,
// Float - float,
// Byte - byte,
// Char - char

//автоматическая упаковка и автоматическая распаковка
public class WrapperNumberTest {
    public static void main(String[] args) {
        Integer i = 10;//прямое присваивание без new Integer - упаковка

        Integer a = 10;

        a++;

        //System.out.println(a.getClass());

        Integer b = 20;
        int c = a + b; //распаковка

        Integer d = c * 20; // упаковка

        d = func3(d);

        System.out.println(d); // 1. распаковка при передаче значения аргумента 2. упаковка результата функции в класс обертку

    }

    public static Integer func1(int a)
    {
        return a+1; //упаковка
    }

    public static Integer func2(int a)
    {
        return a+1; //1. распаковка в int, 2. сложение 3. упаковка
    }

    public static Integer func3(int a)
    {
        return a+1;
    }
}
