package lab14matrix;

public class Main {
    public static void main(String[] args) {

        float[][] array = {
                {1.0f, 2.0f, 3.0f},
                {4.0f, 5.0f, 6.0f},
                {7.0f, 8.0f, 9.0f}
        };

        Matrix matrix = new Matrix(array);
        System.out.println("Матрица:");
        System.out.println(matrix);

        LAVector vector1 = new LAVector(new float[]{1.0f, 2.0f, 3.0f});
        LAVector vector2 = new LAVector(new float[]{4.0f, 5.0f, 6.0f});

        System.out.println("Вектор 1:");
        System.out.println(vector1);

        System.out.println("Вектор 2:");
        System.out.println(vector2);

        LAVector result = matrix.multRVector(vector1);
        System.out.println("Результат умножения матрицы на вектор:");
        System.out.println(result);

        LAVector result2 = matrix.multLVector(vector2);
        System.out.println("Результат умножения вектора на матрицу:");
        System.out.println(result2);

        Matrix transposed = matrix.transp();
        System.out.println("Транспонированная матрица:");
        System.out.println(transposed);

        float determinant = matrix.det();
        System.out.println("Определитель матрицы: ");
        System.out.println(determinant);
    }}
