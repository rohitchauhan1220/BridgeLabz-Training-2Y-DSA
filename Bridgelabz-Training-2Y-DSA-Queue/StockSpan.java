import java.util.*;

public class StockSpan {
    public static int[] getSpan(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            spans[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        return spans;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Spans: " + Arrays.toString(getSpan(prices)));
    }
}
