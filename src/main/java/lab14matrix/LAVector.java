package lab14matrix;

public class LAVector {
    private float[] components;

    public LAVector(int size) {
        components = new float[size]; // вектор заданного размера, заполненный нулями
    }

    public LAVector(float[] components) {
        this.components = components;
    }

    public LAVector(int size, float value) {
        components = new float[size];
        for (int i = 0; i < size; i++) {
            components[i] = value;
        }
    }

    public LAVector plusVector(LAVector other) {
        if (this.components.length != other.components.length) {
            System.out.println("Векторы должны быть одинаковой длины.");
            return null;
        }
        float[] result = new float[components.length];
        for (int i = 0; i < components.length; i++) {
            result[i] = this.components[i] + other.components[i];
        }
        return new LAVector(result);
    }

    public LAVector multNumber(float number) {
        float[] result = new float[components.length];
        for (int i = 0; i < components.length; i++) {
            result[i] = components[i] * number;
        }
        return new LAVector(result);
    }

    public float scalarMult(LAVector other) {
        if (this.components.length != other.components.length) {
            System.out.println("Векторы должны быть одинаковой длины.");
            return 0;
        }
        float sum = 0;
        for (int i = 0; i < components.length; i++) {
            sum += this.components[i] * other.components[i];
        }
        return sum;
    }

    public float abs() { //длина вектора
        float sum = 0;
        for (float value : components) {
            sum += value * value;
        }
        return (float) Math.sqrt(sum);
    }

    public float getComponent(int n) {
        if (n < 0 || n >= components.length) {
            System.out.println("Некорректный индекс компоненты.");
            return 0;
        }
        return components[n];
    }

    public int size() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (float value : components) {
            sb.append(value).append(" ");
        }
        return sb.toString();
    }
}
