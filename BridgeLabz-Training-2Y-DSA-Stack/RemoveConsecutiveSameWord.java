public class RemoveConsecutiveSameWord {
    public static void main(String[] args) {
        String[] arr1 = {"ab", "aa", "aa", "ab"};
        String[] arr2 = {"ab", "aa", "bcd", "ab"};

        System.out.println(solve(arr1)); // 0
        System.out.println(solve(arr2)); // 4
    }

    static int solve(String[] arr) {
        Stack<String> stack = new Stack<>();
        boolean duplicateFound = false;

        for (String word : arr) {
            if (!stack.isEmpty() && stack.peek().equals(word)) {
                // duplicate found → skip pushing
                duplicateFound = true;
            } else {
                stack.push(word);
            }
        }

        // If duplicate found → return 0
        if (duplicateFound)
            return 0;
        else
            return stack.size();
    }
}