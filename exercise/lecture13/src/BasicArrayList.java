import java.util.ArrayList;

public class BasicArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> L = new ArrayList<>();
        L.add(5);
        L.add(6);
        int first = L.get(0).intValue();
        System.out.println(first);
    }
}
