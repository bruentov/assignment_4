import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo;

    public DijkstraSearch(WeightedGraph<V> graph, V sourceData) {
        super(graph.getVertex(sourceData));
        distTo = new HashMap<>();
        for (Vertex<V> v : graph.getVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        dijkstra(graph.getVertex(sourceData));
    }

    private void dijkstra(Vertex<V> start) {
        distTo.put(start, 0.0);
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(new Comparator<Vertex<V>>() {
            @Override
            public int compare(Vertex<V> v1, Vertex<V> v2) {
                return Double.compare(distTo.get(v1), distTo.get(v2));
            }
        });

        pq.add(start);
        while (!pq.isEmpty()) {
            Vertex<V> v = pq.remove();
            marked.add(v);

            for (Map.Entry<Vertex<V>, Double> entry : v.getAdjacentVertices().entrySet()) {
                Vertex<V> w = entry.getKey();
                double weight = entry.getValue();
                if (distTo.get(v) + weight < distTo.get(w)) {
                    distTo.put(w, distTo.get(v) + weight);
                    edgeTo.put(w, v);
                    pq.remove(w);
                    pq.add(w);
                }
            }
        }
    }
}