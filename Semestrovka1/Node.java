import java.util.concurrent.ThreadLocalRandom;

public class Node {
    public int key;
    public int priority;
    public Node left, right;

    public Node(int key) {
        this.key = key;
        this.priority = ThreadLocalRandom.current().nextInt();
    }
}