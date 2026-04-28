import java.util.*;

public class LongestConsecutiveSequence {
    public static int find(int[] arr) {
        if (arr.length == 0) return 0;
        
        Set<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i);

        int best = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int curr = i;
                int streak = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    streak++;
                }
                best = Math.max(best, streak);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Longest: " + find(arr));
    }
}
