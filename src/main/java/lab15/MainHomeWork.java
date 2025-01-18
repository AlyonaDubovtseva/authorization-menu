package lab15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class MainHomeWork {
    public static void main(String[] args) throws FileNotFoundException {
        String[] patterns = {
        "(^|\\s)(Я|я)(\\s|,\\.|\\?|!|$)|(^|\\s)(М|м)оё(\\s|,|\\.|\\?|!|$)|(^|\\s)(М|м)не(\\s|,|\\.|\\?|!|$)",
        "(^|\\s)(м|М)ор(я|ем||е|ю|ей|ями|ях)(\\s|,\\.|\\?|!|$)",
        "(^|\\s)(м|М)уза(\\s|,|\\.|!,|\\?|$)",
        "(^|\\s)(Л|л)юбовь(\\s|,|\\.|\\?|!|$)",
        "(^|\\s)(Д|д)рузья(\\s|,\\.|\\?|!|$)",
        "(^|\\s)(П|п)оэт(\\s|,\\.|\\?|!|$)",
        "(в|В)етры.+веют",
        "(в|В)зор.+(Вст|вст|т|Т)ревожит",
        };

        Scanner scanner = new Scanner(new File("pushkin.txt"));


        int lineNumber = 0; // счётчик строк
        int[] foundCounts = new int[patterns.length]; // счётчик для каждого шаблона

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            lineNumber++;
            for (int i = 0; i < patterns.length; i++) {
                if (foundCounts[i] < 5) {
                    Pattern pattern = Pattern.compile(patterns[i]);
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        System.out.printf("Шаблон %d найден в строке %d: %s%n", i + 1, lineNumber, line.trim());
                        foundCounts[i]++;
                    }
                }
            }
        }

        scanner.close();

    }
}
