import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }


    public void add(T fruit) {
        this.fruits.add(fruit);
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : this.fruits) {
            weight += fruit.getMas();
        }
        return weight;
    }

    public boolean compare(Box<? extends Fruit> other) {
        return this.getWeight() == other.getWeight();
    }

    public void pour(Box<T> in) {
        while (this.fruits.size() > 0) {
            in.add(this.fruits.remove(0));
        }
    }
}
