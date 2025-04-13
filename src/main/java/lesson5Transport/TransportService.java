package lesson5Transport;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class TransportService {
    private File file;

    public TransportService(String file) {
        this.file = new File(file);
    }

    public ListArrayImpl<Transport> readAll () throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        if(scanner.hasNextLine()) {
            scanner.nextLine();
        }

        ListArrayImpl<Transport> result = new ListArrayImpl<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String [] str = line.split(";");
            result.add (
                    switch (str[0]) {// это функция
                        case "bus" -> new Bus(str[1], str[2], str[3], str[4]);
                        case "tram" -> new Tram(str[1], str[2], str[3], str[4]);
                        case "trolleybus" -> new Trolleybus(str[1], str[2], str[3], str[4]);
                        default -> null;
                    }
            );
        }
        scanner.close();
        return result;
    }

    public ListArrayImpl<Bus> readAllBus () throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        ListArrayImpl<Bus> result = new ListArrayImpl<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String [] str = line.split(";");
            if(str[0].equals("bus")) {
                result.add(new Bus(str[1], str[2], str[3], str[4]));
            }

        }
        scanner.close();
        return result;
    }

    public ListArrayImpl<Trolleybus> readAllTroll () throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        ListArrayImpl<Trolleybus> result = new ListArrayImpl<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String [] str = line.split(";");
            if(str[0].equals("trolleybus")) {
                result.add(new Trolleybus(str[1], str[2], str[3], str[4]));
            }
        }
        scanner.close();
        return result;
    }

    public ListArrayImpl<Tram> readAllTram () throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        ListArrayImpl<Tram> result = new ListArrayImpl<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String [] str = line.split(";");
            if(str[0].equals("tram")) {
                result.add(new Tram(str[1], str[2], str[3], str[4]));
            }
        }
        scanner.close();
        return result;
    }


}
