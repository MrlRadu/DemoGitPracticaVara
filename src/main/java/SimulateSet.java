import java.util.*;

public class SimulateSet {
    public static void main(String[] args) {
        AbstractSet<Integer> set = new AbstractSet<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };

        set.add(3);
        set.add(9);
        set.add(4);
        set.add(6);


        Enumeration<Integer> e = (Enumeration<Integer>) set;

        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }


}
