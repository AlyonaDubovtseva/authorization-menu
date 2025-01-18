package lab14matrix;

public class Matrix {
    private float[][] components;

    public Matrix(float[][] components) {
        this.components = components;
    }

    public Matrix(LAVector[] rows) { //матрица из массива строк-векторов

        if (rows == null || rows.length == 0) {
            System.out.println("Ошибка: массив строк не должен быть пустым.");
            return;
        }

        int rowCount = rows.length;
        int columnCount = rows[0].size();

        components = new float[rowCount][columnCount];

        for(int i = 0; i < rowCount; i++) {
            if (rows[i].size() != columnCount) {
                System.out.println("Ошибка: все строки должны быть одинаковой длины.");
                return;
            } for (int j = 0; j < columnCount; j++) {
                components[i][j] = rows[i].getComponent(j);
            }
        }

    }

    public Matrix(int columns, int rows) {
        components = new float[rows][columns];
    }

    public Matrix(int size, float diagElement) { //квадратная матрица у которой на главной диагонали стоят diagElement, остальные элементы — нули
        components = new float[size][size];
        for (int i = 0; i < size; i++) {
            components[i][i] = diagElement;
        }
    }

    public int rows() {
        return components.length;
    }

    public int columns() {
        return components[0].length;
    }

    public float det() {
        if (components.length != components[0].length) {
            System.out.println("Определитель можно вычислить только для квадратных матриц.");
            return 0;
        }
        return calculateDeterminant(components);
    }

    private float calculateDeterminant(float[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        float det = 0;
        for (int i = 0; i < n; i++) {
            float[][] minor = getMinor(matrix, i);
            det += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(minor);
        }
        return det;
    }

    private float[][] getMinor(float[][] matrix, int col) {
        int n = matrix.length;
        float[][] minor = new float[n - 1][n - 1];
        for (int i = 1; i < n; i++) {
            int minorCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                minor[i - 1][minorCol++] = matrix[i][j];
            }
        }
        return minor;
    }

    public LAVector multRVector(LAVector vector) {
        if (vector.size() != columns()) {
            System.out.println("Размер вектора не соответствует количеству столбцов в матрице.");
            return null;
        }
        float[] result = new float[rows()];
        for (int i = 0; i < rows(); i++) {
            float sum = 0;
            for (int j = 0; j < columns(); j++) {
                sum += components[i][j] * vector.getComponent(j);
            }
            result[i] = sum;
        }
        return new LAVector(result);
    }

    public LAVector multLVector(LAVector vector) {
        if (vector.size() != rows()) {
            System.out.println("Размер вектора не соответствует количеству строк в матрице.");
            return null;
        }
        float[] result = new float[columns()];
        for (int j = 0; j < columns(); j++) {
            float sum = 0;
            for (int i = 0; i < rows(); i++) {
                sum += components[i][j] * vector.getComponent(i);
            }
            result[j] = sum;
        }
        return new LAVector(result);
    }

    public Matrix transp() {
        float[][] transposed = new float[columns()][rows()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                transposed[j][i] = components[i][j];
            }
        }
        return new Matrix(transposed);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (float[] row : components) {
            for (float value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
