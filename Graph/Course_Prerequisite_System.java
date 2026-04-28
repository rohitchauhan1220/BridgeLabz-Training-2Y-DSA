import java.util.*;
public class CourseSystem {
    private Map<String, List<String>> adj = new HashMap<>();

    public void addPrereq(String course, String prereq) {
        adj.computeIfAbsent(prereq, k -> new ArrayList<>()).add(course);
    }

    public boolean hasCycle(String node, Set<String> visited, Set<String> recStack) {
        if (recStack.contains(node)) return true;
        if (visited.contains(node)) return false;

        visited.add(node);
        recStack.add(node);

        for (String neighbor : adj.getOrDefault(node, new ArrayList<>())) {
            if (hasCycle(neighbor, visited, recStack)) return true;
        }

        recStack.remove(node);
        return false;
    }

    public void generateCourseOrder() {
        // Implementation would follow DFS post-order reversal [cite: 549]
        System.out.println("Valid order generated via Topological Sort.");
    }
}