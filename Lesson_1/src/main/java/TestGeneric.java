import java.util.ArrayList;
import java.util.Arrays;

public class TestGeneric<T> {
    private final T[] content;

    public TestGeneric(T[] content) {
        this.content = content;
    }

    public void moveItems(int in, int to) {
        T tmp = content[in];
        content[in] = content[to];
        content[to] = tmp;
    }

    public ArrayList<T> toList() {
        ArrayList<T> arrList;
        arrList = new ArrayList<>(Arrays.asList(this.content));
        return arrList;
    }


    @Override
    public String toString() {
        return Arrays.toString(content);
    }
}
