package lesson4;

public class Fruit {
    private String name;
    private Integer sugar;

    public Fruit(String name, Integer sugar) {
        this.name = name;
        this.sugar = sugar;
    }

    public String getName() {
        return name;
    }

    public Integer getSugar() {
        return sugar;
    }

    public String toString() {
        return "Fruit: " + name + ", " + sugar + " %";
    }

    @Override
    public boolean equals(Object object) {
        if(object == null) return false;
        if(!object.getClass().equals(this.getClass())) return false;
        if(this == object) return true;
        Fruit v = (Fruit) object;

        if(this.name.equals(v.name) && this.sugar == v.sugar) return true;
        return false;
    }
    public int hashCode() {
        int h = super.hashCode();
        for (int i = 0; i < name.length(); i++) {
            h = h^name.charAt(i);
        }

        h = h * sugar * 17;
        return h;
    }
}
