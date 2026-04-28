import java.util.*;

public class SubarraysWithZeroSum {
    public static List<int[]> findSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        int sum = 0;
        map.computeIfAbsent(0, k -> new ArrayList<>()).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int startIdx : map.get(sum)) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<int[]> lists = findSubarrays(arr);

        System.out.println("Array: " + Arrays.toString(arr));
        for (int[] sub : lists) {
            System.out.println(Arrays.toString(sub));
        }
    }
}
