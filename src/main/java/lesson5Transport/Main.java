package lesson5Transport;

public class Main {
    public static void main(String[] args) throws Exception {
        TransportService transportService= new TransportService("transport.csv");
        ListArrayImpl<Transport> transports = transportService.readAll();
        System.out.println(transports);

        TransportPrintService service = new TransportPrintService("transport.csv");
        System.out.println("----ОТСОРТИРОВАННЫЕ ПАРКОВЫЕ НОМЕРА----");
        service.PrintParkNumber2(transports);

        System.out.println("----ОТСОРТИРОВАННЫЕ НОМЕРА МАРШРУТОВ----");
        service.printRouteNumber(transports);

        System.out.println("----ВСЕ НОМЕРА МАРШРУТОВ----");
        service.printQualityOfNumbers(transports);

        System.out.println();

        System.out.println("----ВСЕ ВИДЫ ТРАНСПОРТА----");
        service.printAllTypeTransport(transports);

        System.out.println("----ВСЕ НОМЕРА И КОЛИЧЕСТОВ ТРАНСПОРТА НА НИХ----");
        service.printNumberAndQualityTransport(transports);

    }
}
