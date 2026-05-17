import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Size;Time;Iterations");
        Random rand = new Random();
        for (int size = 100; size <= 10000; size += 100) {
            int V = size;     // Вершины
            int E = size * 2; // Ребра

            Graph g = new Graph(V);
            for (int i = 0; i < E; i++) {
                int u = rand.nextInt(V);
                int v = rand.nextInt(V);
                g.addEdge(u, v);
            }
            Graph.iterations = 0;
            long startTime = System.nanoTime();
            g.performDFS();
            long stopTime = System.nanoTime();
            long executionTime = stopTime - startTime;
            int totalSize = V + E;
            System.out.println(totalSize + ";" + executionTime + ";" + Graph.iterations);
        }
    }
}