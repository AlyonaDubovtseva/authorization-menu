package lesson1;

public class List403Impl implements List403 {
    private Integer [] values;
    private int size;

    public List403Impl() {
        this.values = new Integer[10];
        this.size = 0;
    }

    public void add(Integer element) {
        if (size >= values.length) {
            grow();
        }
        values[size++] = element;

    }

    public void add(Integer element, int position) throws IndexOutOfRangeException {
        if (position > size || position < 0) {
            throw new IndexOutOfRangeException("Выход за массив");
        }
        for (int i = size; i != position; i--) {
            values[i] = values[i - 1];
        }
        values[position] = element;
        size++;

    }

    public Integer remove(int position) throws IndexOutOfRangeException {
        if (position > size - 1 || position < 0) {
            throw new IndexOutOfRangeException("Выход за массив");
        }
        Integer temp = values[position];
        for (int i = position; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        size--;
        return temp;
    }

    public int size() {
        return size;
    }

    public Integer get(int position) throws IndexOutOfRangeException {
        if (position > size - 1 || position < 0) {
            throw new IndexOutOfRangeException("Выход за массив");
        }
        return values[position];
    }

    public void sort(boolean asc) {
        if(asc) {
            for (int i = size - 1; i >= 1 ; i--) {
                for (int j = 0; j < i; j++) {
                    if(values[j] > values[j + 1]) {
                        toSwap(j, j + 1);
                    }
                }
            }
        } else {
            for(int i = size - 1; i >= 1; i--) {
                for(int j = 0; j < i; j++) {
                    if(values[j] < values[j + 1]) {
                        toSwap(j, j + 1);
                    }
                }
            }
        }
    }
    
    private void toSwap(int first, int second) {
        int temp = values[first];
        values[first] = values[second];
        values[second] = temp;
    }

    private void grow() {
        Integer [] newValues = new Integer[(int)(size * 1.5)];
        for(int i = 0; i < size; i++) {
            newValues[i] = values[i];
        }
        values = newValues;

    }

    public void printer() {
        for (int i = 0; i <size ; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

}
