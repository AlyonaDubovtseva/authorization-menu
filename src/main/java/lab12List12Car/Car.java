package lab12List12Car;

public class Car implements CanCompare {
    private String brand;
    private int horsepower;
    private int price;

    public Car(String brand, int horsepower, int price) {
        this.brand = brand;
        this.horsepower = horsepower;
        this.price = price;
    }
    public void drive() {
        System.out.println("car is driving");
    }

    public int getHorsepower() {
        return horsepower;
    }

    @Override
    public int compare(CanCompare other) {
        return this.horsepower - ((Car) other).getHorsepower();
    }

    @Override
    public String toString() {
        return brand + " (" + horsepower + " HP, $" + price + ")";
    }
}