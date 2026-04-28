import java.util.*;

public class HashingProblems {

    // Find duplicates in array
    public static void findDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        System.out.print("Duplicates: ");
        for (int dup : duplicates) {
            System.out.print(dup + " ");
        }
        System.out.println();
    }

    // Find intersection of two arrays
    public static void findIntersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for (int num : arr1) {
            set1.add(num);
        }

        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }

        System.out.print("Intersection: ");
        for (int num : intersection) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Find union of two arrays
    public static void findUnion(int[] arr1, int[] arr2) {
        Set<Integer> union = new HashSet<>();

        for (int num : arr1) {
            union.add(num);
        }

        for (int num : arr2) {
            union.add(num);
        }

        System.out.print("Union: ");
        for (int num : union) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : str1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }

        return true;
    }

    // Find first non-repeating character
    public static char firstNonRepeatingChar(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0'; // No non-repeating character found
    }

    // Two sum problem
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{-1, -1}; // No solution found
    }

    public static void main(String[] args) {
        // Find duplicates
        int[] arr = {1, 2, 3, 4, 2, 5, 3, 6};
        findDuplicates(arr);

        // Intersection and Union
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};
        findIntersection(arr1, arr2);
        findUnion(arr1, arr2);

        // Anagrams
        System.out.println("Are 'listen' and 'silent' anagrams? " + areAnagrams("listen", "silent"));
        System.out.println("Are 'hello' and 'world' anagrams? " + areAnagrams("hello", "world"));

        // First non-repeating character
        System.out.println("First non-repeating char in 'swiss': " + firstNonRepeatingChar("swiss"));
        System.out.println("First non-repeating char in 'aabbcc': " + firstNonRepeatingChar("aabbcc"));

        // Two sum
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Two sum indices for target " + target + ": [" + result[0] + ", " + result[1] + "]");
    }
}