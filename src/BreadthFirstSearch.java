import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph, V sourceData) {
        super(graph.getVertex(sourceData));
        bfs(graph.getVertex(sourceData));
    }

    private void bfs(Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        marked.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.remove();
            for (Vertex<V> vertex : v.getAdjacentVertices().keySet()) {
                if (!marked.contains(vertex)) {
                    edgeTo.put(vertex, v);
                    marked.add(vertex);
                    queue.add(vertex);
                }
            }
        }
    }
}