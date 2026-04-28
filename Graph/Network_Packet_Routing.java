import java.util.*;
public class NetworkRouting {
    int[][] matrix = new int[6][6];
    List<Integer>[] adjList = new ArrayList[6];
    public boolean isConnected(int start, int totalNodes) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbor : adjList[curr]) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
        return visited.size() == totalNodes;
    }
}