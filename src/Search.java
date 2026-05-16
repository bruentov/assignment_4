import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Search<V> {
    protected Set<Vertex<V>> marked;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected Vertex<V> source;

    public Search(Vertex<V> source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> v) {
        return marked.contains(v);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = v; x != source; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(source);
        return path;
    }
}