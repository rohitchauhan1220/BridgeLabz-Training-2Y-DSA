import java.util.*;

public class PairWithSum {
    public static boolean check(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int x : arr) {
            if (set.contains(target - x)) {
                System.out.println("Pair: (" + x + ", " + (target - x) + ")");
                return true;
            }
            set.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;
        if (!check(arr, target)) System.out.println("No pair found.");
    }
}
