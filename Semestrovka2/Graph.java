import java.util.ArrayList;

public class Graph {
    int V;
    ArrayList<ArrayList<Integer>> adj;
    public static int iterations = 0;
    public Graph(int V) {
        this.V = V;
        this.adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        iterations++;
        for (int neighbor : adj.get(v)) {
            iterations++;
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }
    public void performDFS() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }
}