import java.util.*;

public class DijkstrasAlgorithm {

    private int vertices;
    private List<List<Node>> adjacencyList;

    static class Node implements Comparable<Node> {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public DijkstrasAlgorithm(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add edge to the graph
    public void addEdge(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Node(destination, weight));
        // For undirected graph, add reverse edge
        adjacencyList.get(destination).add(new Node(source, weight));
    }

    // Dijkstra's algorithm
    public int[] dijkstra(int source) {
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;

            for (Node neighbor : adjacencyList.get(currentVertex)) {
                int newDistance = distances[currentVertex] + neighbor.weight;

                if (newDistance < distances[neighbor.vertex]) {
                    distances[neighbor.vertex] = newDistance;
                    pq.add(new Node(neighbor.vertex, newDistance));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        DijkstrasAlgorithm graph = new DijkstrasAlgorithm(6);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 10);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 6);
        graph.addEdge(4, 5, 3);

        int source = 0;
        int[] distances = graph.dijkstra(source);

        System.out.println("Shortest distances from vertex " + source + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Vertex " + i + " : " + distances[i]);
        }
    }
}