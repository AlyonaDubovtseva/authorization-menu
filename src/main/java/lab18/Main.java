package lab18;

public class Main {
    public static void main(String[] args) {
        CalculateIntegralLeft calculateIntegralLeft = new CalculateIntegralLeft(0, Math.PI/2, new Sinus());
        System.out.println(calculateIntegralLeft.get());

        CalculateIntegralRight calculateIntegralRight = new CalculateIntegralRight(0, Math.PI/2, new Sinus());
        System.out.println(calculateIntegralRight.get());

        CalculateTrapezoid calculateTrapezoid = new CalculateTrapezoid(0, Math.PI/2, new Sinus());
        System.out.println(calculateTrapezoid.get());

        CalculateIntegralMideum calculateIntegralMideum = new CalculateIntegralMideum(0, Math.PI/2, new Sinus());
        System.out.println(calculateIntegralMideum.get());

    }
}
