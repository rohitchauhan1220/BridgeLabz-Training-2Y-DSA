import java.util.*;
public class SocialNetwork {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void addFriendship(String u, String v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public List<String> getFriends(String user) {
        return adjList.getOrDefault(user, new ArrayList<>());
    }

    public boolean isDirectlyConnected(String u, String v) {
        return adjList.containsKey(u) && adjList.get(u).contains(v);
    }

    public int getDegreeOfSeparation(String start, String target) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distance = new HashMap<>();

        queue.add(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(target)) return distance.get(current);

            for (String friend : adjList.getOrDefault(current, new ArrayList<>())) {
                if (!distance.containsKey(friend)) {
                    distance.put(friend, distance.get(current) + 1);
                    queue.add(friend);
                }
            }
        }
        return -1; // No connection
    }
}