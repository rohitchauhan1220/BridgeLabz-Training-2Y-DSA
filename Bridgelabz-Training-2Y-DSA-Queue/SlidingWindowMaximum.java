import java.util.*;

public class SlidingWindowMaximum {
    public static int[] solve(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) return new int[0];
        
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();

            dq.addLast(i);

            if (i >= k - 1) res[i - k + 1] = nums[dq.peekFirst()];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Max: " + Arrays.toString(solve(nums, k)));
    }
}
