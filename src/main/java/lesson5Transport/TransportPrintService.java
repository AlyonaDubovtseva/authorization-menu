package lesson5Transport;

import lesson3_1.Set2;
import lesson3_1.Set2Impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

public class TransportPrintService {

    public <T extends Transport> void PrintParkNumber2(ListArrayImpl<T> list) throws IndexOutOfRangeException {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(Transport o1, Transport o2) {
                return Integer.compare(Integer.parseInt(o1.getNumber()), Integer.parseInt(o2.getNumber()));
            }
        });
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNumber() + ", " +
                    list.get(i).getWorkTimeBegin());
        }
    }

    public <T extends Transport> void printRouteNumber(ListArrayImpl<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(Transport o1, Transport o2) {
                return Integer.compare(Integer.parseInt(o1.getRouteNumber()), Integer.parseInt(o2.getRouteNumber()));
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getRouteNumber() + ", "
            + list.get(i).getWorkTimeBegin() + ", " + list.get(i).getWorkTimeEnd());
        }
    }

    public  <T extends Transport>  void printQualityOfNumbers(ListArrayImpl<T> list) {
        Set2Impl<String> set = new Set2Impl<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i).getRouteNumber());
        }
        System.out.println(set);
    }

    private File file;

    public TransportPrintService(String file) {
        this.file = new File(file);
    }

    public  <T extends Transport>  void printAllTypeTransport(ListArrayImpl<T> list) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Set2<String> transportTypes = new Set2Impl<>();

        if(scanner.hasNextLine()) scanner.nextLine();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String [] str = line.split(";");
            if(str.length > 0) {
                transportTypes.add(str[0]);
            }
        }
        scanner.close();

        System.out.println(transportTypes);
    }

    public  <T extends Transport>  void printNumberAndQualityTransport(ListArrayImpl<T> list) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Set2<String> numbers = new Set2Impl<>();
        ListArrayImpl<String> lines = new ListArrayImpl<>();

        if(scanner.hasNextLine()) scanner.nextLine();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
            String [] str = line.split(";");
            if(str.length > 2) {
                numbers.add(str[2]);
            }
        }
        scanner.close();

        for (int i = 0; i < numbers.size(); i++) {
            String route = numbers.get(i);
            int count = 0;

            for (int j = 0; j < lines.size(); j++) {
                String line = lines.get(j);
                String[] str = line.split(";");
                if (str.length > 2 && str[2].equals(route)) {
                    count++;
                }
            }
            System.out.println(route + ", " + count);
        }


    }



}
