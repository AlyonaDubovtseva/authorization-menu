package lab16expedition;

import java.util.Random;

public class Car {

    private Person[] passengers;
    private Random random = new Random();
    private final int MAX_SEAT = 5;
    private int passengerCount = 0;

    public Car() {
        passengers = new Person[MAX_SEAT];
    }

    public boolean addPassenger(Person person) {
        if (passengerCount < MAX_SEAT) {
            passengers[passengerCount] = person;
            passengerCount++;
            return true;
        }
        return false;
    }

    public Person[] getPassengers() {
        return passengers;
    }

    public void removeAllPassengers() {
        for(int i = 0; i < passengerCount; i++) {
            passengers[i] = null;
        }
        passengerCount = 0;
    }

    public boolean carBroken() {
        return random.nextInt(100) < 60;
    }

    public int freeSeats() {
        return  MAX_SEAT - passengerCount;
    }


}
