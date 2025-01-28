package lab18;

public class CalculateIntegralMideum extends AbstractCalculateIntegral {

    private static final int N = 1000;

    public CalculateIntegralMideum(double a, double b, Function function) {
        super(a, b, function);
    }

    @Override
    public double get() {
        double sum = 0;
        double h = (b - a) / N;

        for(int i = 0; i < N; i++) {
            sum += h * function.calculate(a + (h /  2) * i);
        }

        return sum;
    }
}
