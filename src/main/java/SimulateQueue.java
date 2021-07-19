import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class SimulateQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(8);
        queue.add(3);
        queue.add(14);
        queue.add(7);

        Enumeration<Integer> e = queue.stream().collect(Collectors.toCollection());
    }
}
