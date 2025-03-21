package lesson3_1;

public class Auto {
    private String model;
    private int horsepower;
    private int year;
    private String color;

    public Auto(String model, int horsepower, int year, String color) {
        this.model = model;
        this.horsepower = horsepower;
        this.year = year;
        this.color = color;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;

        Auto auto = (Auto) object;

        return year == auto.year &&
                horsepower == auto.horsepower &&
                (model == null ? auto.model == null : model.equals(auto.model)) &&
                (color == null ? auto.color == null : color.equals(auto.color));
    }
    @Override
    public String toString() {
        return "Auto" +
                " model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", horsepower=" + horsepower;
    }
}
