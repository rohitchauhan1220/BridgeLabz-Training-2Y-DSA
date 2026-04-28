public class RecursionProblems {

    // Factorial using recursion
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Tower of Hanoi
    public static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + fromRod + " to " + toRod);
            return;
        }
        towerOfHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);
        towerOfHanoi(n - 1, auxRod, toRod, fromRod);
    }

    // Check if string is palindrome using recursion
    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }

    // Sum of digits using recursion
    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }

    // Power function using recursion
    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }

    // Binary search using recursion
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, left, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {
        // Factorial
        System.out.println("Factorial of 5: " + factorial(5));

        // Tower of Hanoi
        System.out.println("\nTower of Hanoi for 3 disks:");
        towerOfHanoi(3, 'A', 'C', 'B');

        // Palindrome check
        String str1 = "radar";
        String str2 = "hello";
        System.out.println("\nIs '" + str1 + "' palindrome? " + isPalindrome(str1, 0, str1.length() - 1));
        System.out.println("Is '" + str2 + "' palindrome? " + isPalindrome(str2, 0, str2.length() - 1));

        // Sum of digits
        System.out.println("\nSum of digits of 12345: " + sumOfDigits(12345));

        // Power
        System.out.println("2^5 = " + power(2, 5));

        // Binary search
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;
        int result = binarySearch(arr, 0, arr.length - 1, target);
        System.out.println("\nBinary search for " + target + " in array: index " + result);
    }
}