public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addEdge("A", "B", 2.0);
        graph.addEdge("A", "C", 5.0);
        graph.addEdge("B", "C", 1.0);
        graph.addEdge("B", "D", 4.0);
        graph.addEdge("C", "D", 1.0);

        System.out.println("--- BFS Connection Test ---");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, "A");
        if (bfs.hasPathTo(graph.getVertex("D"))) {
            for (Vertex<String> v : bfs.pathTo(graph.getVertex("D"))) {
                System.out.print(v.getData() + " ");
            }
            System.out.println();
        }

        System.out.println("--- Dijkstra Shortest Path Test ---");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "A");
        if (dijkstra.hasPathTo(graph.getVertex("D"))) {
            for (Vertex<String> v : dijkstra.pathTo(graph.getVertex("D"))) {
                System.out.print(v.getData() + " ");
            }
            System.out.println();
        }
    }
}