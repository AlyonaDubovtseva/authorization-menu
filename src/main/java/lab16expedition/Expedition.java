package lab16expedition;

public class Expedition {
    private Car[] cars;
    private final int distance = 1000;
    private final int interval = 50;

    public Expedition(int carCount) {
        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
    }

    public void start() {
        int distanceCovered = 0;

        while (distanceCovered < distance) {
            distanceCovered += interval;
            System.out.println("Пройдено: " + distanceCovered + " км.");

            for (int i = 0; i < cars.length; i++) {
                Car car = cars[i];

                if(car.carBroken()) {
                    System.out.println("Машина " + (i + 1) + " сломалась.");


                }
            }
        }
    }

    public void movePassenger(Car brokenCar) throws CarBrokeException {

    }
}
