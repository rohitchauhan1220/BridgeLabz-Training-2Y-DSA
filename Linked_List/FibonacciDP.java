public class FibonacciDP {

    // Recursive approach (inefficient)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Memoization approach (Top-down DP)
    public static int fibonacciMemoization(int n) {
        int[] memo = new int[n + 1];
        return fibonacciMemo(n, memo);
    }

    private static int fibonacciMemo(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];

        memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
        return memo[n];
    }

    // Tabulation approach (Bottom-up DP)
    public static int fibonacciTabulation(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Space optimized approach
    public static int fibonacciOptimized(int n) {
        if (n <= 1) return n;

        int prev2 = 0, prev1 = 1;
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println("Fibonacci of " + n + " using recursion: " + fibonacciRecursive(n));
        System.out.println("Fibonacci of " + n + " using memoization: " + fibonacciMemoization(n));
        System.out.println("Fibonacci of " + n + " using tabulation: " + fibonacciTabulation(n));
        System.out.println("Fibonacci of " + n + " using optimized: " + fibonacciOptimized(n));

        // Print first 10 fibonacci numbers
        System.out.print("First 10 Fibonacci numbers: ");
        for (int i = 0; i <= 10; i++) {
            System.out.print(fibonacciOptimized(i) + " ");
        }
        System.out.println();
    }
}