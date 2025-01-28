package lab18;

public class CalculateIntegralLeft extends AbstractCalculateIntegral {

    private static final int N = 3000;

    public CalculateIntegralLeft(double a, double b, Function function) {
        super(a, b, function);
    }

    @Override
    public double get() {
        double sum = 0;
        double h = (b - a) / N;

        for(int i = 0; i < N; i++) {
            sum += h * function.calculate(a + h * i);
        }

        return sum;
    }
}
