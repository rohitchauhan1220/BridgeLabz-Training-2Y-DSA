import java.util.*;
public class CityRoads {
    static class Edge {
        String to;
        int weight;
        Edge(String to, int weight) { this.to = to; this.weight = weight; }
    }

    private Map<String, List<Edge>> adj = new HashMap<>();

    public void findReachable(String start, Set<String> visited) {
        visited.add(start);
        System.out.println("Intersection reachable: " + start);

        for (Edge edge : adj.getOrDefault(start, new ArrayList<>())) {
            if (!visited.contains(edge.to)) {
                findReachable(edge.to, visited);
            }
        }
    }

}