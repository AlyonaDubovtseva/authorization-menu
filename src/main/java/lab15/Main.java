package lab15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        //Найди все числа в строке
        //регулярное выражение для чисел — \\d+

        /*String text1 = "В коробке 12 яблок, 34 груши и 56 слив.";

        Pattern pattern1 = Pattern.compile("\\d+");
        Matcher matcher1 = pattern1.matcher(text1);

        while (matcher1.find()){
            System.out.println(matcher1.group());
        }

        //Найди в строке все слова, которые начинаются с заглавной буквы
        //[А-Я][а-я]+


        String text2 = "Привет, Мир! Сегодня Отличная Погода.";

        Pattern pattern2 = Pattern.compile("[А-Я][а-я]+");
        Matcher matcher2 = pattern2.matcher(text2);

        while (matcher2.find()) {
            System.out.println(matcher2.group());
        }

        //Найди в строке все слова, которые состоят ровно из 4 букв.
        //Подсказка: \\b[А-Яа-я]{4}\\b

        String text3 = "Это тестовая строка для поиска слов ляляля";

        Pattern pattern3 = Pattern.compile("\\b[А-Яа-я]{4}\\b");
        Matcher matcher3 = pattern3.matcher(text3);

        while(matcher3.find()) {
            System.out.println(matcher3.group());
        }
*/
        String text = "Море, любовь, молоко, лимон, Лист, лампа, мореход, мать, лук.";

        // Регулярное выражение: слова длиной от 2 до 5 символов, начинающиеся на 'м' или 'л'
        String regex = "\\b[МмЛл]\\w+\\b";

        // Компиляция шаблона
        Pattern pattern = Pattern.compile(regex);

        // Связываем шаблон с текстом
        Matcher matcher = pattern.matcher(text);

        System.out.println("Найденные слова:");

        // Ищем совпадения
        while (matcher.find()) {
            System.out.println(matcher.group()); // Выводим найденное слово
        }



    }
}
