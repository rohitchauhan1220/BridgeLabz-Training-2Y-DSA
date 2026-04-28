public class KnapsackDP {

    // 0/1 Knapsack Problem using DP
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table dp[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        values[i - 1] + dp[i - 1][w - weights[i - 1]],  // Include item
                        dp[i - 1][w]  // Exclude item
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];  // Exclude item
                }
            }
        }

        return dp[n][capacity];
    }

    // Space optimized version
    public static int knapsackOptimized(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            for (int w = capacity; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], values[i] + dp[w - weights[i]]);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        System.out.println("Maximum value using 0/1 Knapsack: " + knapsack(weights, values, capacity));
        System.out.println("Maximum value using optimized approach: " + knapsackOptimized(weights, values, capacity));

        // Another example
        int[] values2 = {1, 4, 5, 7};
        int[] weights2 = {1, 3, 4, 5};
        int capacity2 = 7;

        System.out.println("Another example - Max value: " + knapsack(weights2, values2, capacity2));
    }
}