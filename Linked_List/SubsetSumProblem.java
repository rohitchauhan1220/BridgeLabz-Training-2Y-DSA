import java.util.*;

public class SubsetSumProblem {

    // Recursive function to check if subset with given sum exists
    public static boolean isSubsetSum(int[] set, int n, int sum) {
        // Base Cases
        if (sum == 0) return true;
        if (n == 0) return false;

        // If last element is greater than sum, ignore it
        if (set[n - 1] > sum) {
            return isSubsetSum(set, n - 1, sum);
        }

        // Check if sum can be obtained by:
        // 1. Including the last element
        // 2. Excluding the last element
        return isSubsetSum(set, n - 1, sum) ||
               isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    // DP approach for subset sum
    public static boolean isSubsetSumDP(int[] set, int sum) {
        int n = set.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // If sum is 0, true
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // If set is empty, false (except sum = 0)
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        // Fill the subset table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < set[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    // Find all subsets that sum to target
    public static void findSubsets(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findSubsetsUtil(arr, 0, target, current, result);

        System.out.println("Subsets that sum to " + target + ":");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    private static void findSubsetsUtil(int[] arr, int index, int target,
                                       List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (arr[i] > target) continue;

            current.add(arr[i]);
            findSubsetsUtil(arr, i + 1, target - arr[i], current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        System.out.println("Recursive approach:");
        System.out.println("Is there a subset with sum " + sum + "? " + isSubsetSum(set, set.length, sum));

        System.out.println("\nDP approach:");
        System.out.println("Is there a subset with sum " + sum + "? " + isSubsetSumDP(set, sum));

        System.out.println("\nFinding all subsets:");
        findSubsets(set, sum);

        // Another example
        int[] set2 = {1, 2, 3, 4, 5};
        int sum2 = 7;
        System.out.println("\nFor set {1,2,3,4,5} and sum 7:");
        findSubsets(set2, sum2);
    }
}