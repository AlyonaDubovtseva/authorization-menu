package lab15;
//C:\\Users\\manya\\IdeaProjects\\11-403\\src\\main\\java\\lab15\\pushkin.txt"
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.regex.*;

public class Main2 {
    public static void main(String[] args) {
        // Регулярные выражения для поиска
        String[] patterns = {
                "\\b[Яя]|\\b[Мм]не|\\b[Мм]о[её]\\b", // Я, мне, моё
                "\\b[Мм]ор\\w*\\b", // море (моря, морем, морю...)
                "\\b[Мм]уз[а-я]*\\b", // муза
                "\\b[Лл]юбов[а-я]*\\b", // любовь
                "\\b[Вв]етры.+?веют\\b", // ... веют
                "\\b[Дд]рузья\\b", // друзья
                "\\b[Пп]оэт[а-я]*\\b", // поэт
                "\\b[Вв]зор.+?(вс)?тревожит\\b" // ... (вс)тревожит
        };

        try (Scanner scanner = new Scanner(new File("pushkin.txt"))) {
            int lineNumber = 0;
            int foundLinesCount = 0;  // Счётчик строк с найденными совпадениями

            // Читаем файл построчно
            while (scanner.hasNextLine() && foundLinesCount < 5) {
                String line = scanner.nextLine();
                lineNumber++;

                // Проверяем строку на совпадения с любым из паттернов
                for (String pattern : patterns) {
                    Pattern compiledPattern = Pattern.compile(pattern);
                    Matcher matcher = compiledPattern.matcher(line);

                    if (matcher.find()) {
                        // Если хотя бы одно совпадение найдено, выводим номер строки
                        System.out.println("Найдено совпадение в строке " + lineNumber);
                        foundLinesCount++;
                        break; // Выход из цикла после первого совпадения в строке
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}



