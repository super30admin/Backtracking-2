// Time Complexity : O(n * 2 ^ n)
// Space Complexity : O(n * 2 ^ n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> results;

    public List<List<Integer>> subsets(int[] nums) {
        results = new ArrayList<>();

        // helperRecursion(nums, 0, new ArrayList<>());
        helperIterativeRecursion(nums, 0, new ArrayList<>());
        // helperWithoutRecursion(nums);
        // helperBitManipulation(nums);
        return results;
    }

    // private void helperBitManipulation(int[] nums) {
    //     int n = nums.length;
    //     int end = (int) Math.pow(2, n);
    //     for (int i = 0; i < end; i++) {
    //         String binaString = convertToBinary(i, n);
    //         List<Integer> subSet = new ArrayList<>();
    //         for (int j = 0; j < n; j++) {
    //             if (binaString.charAt(j) == '1') {
    //                 subSet.add(nums[j]);
    //             }
    //         }
    //         results.add(subSet);
    //     }
    // }

    // private String convertToBinary(int number, int n) {
    //     if (number == 0) {
    //         return String.format("%" + n + "s", 0).replace(' ', '0');
    //     }
    //     StringBuilder stringBuilder = new StringBuilder();

    //     while (number > 0) {
    //         stringBuilder.append(number % 2);
    //         number /= 2;
    //     }
    //     return String.format("%" + n + "s", stringBuilder.reverse()).replace(' ', '0');

    //     // OR
    //     // return String.format("%" + n + "s", Integer.toBinaryString(number)).replace('
    //     // ', '0');
    // }

    // private void helperWithoutRecursion(int[] nums) {
    //     results.add(new ArrayList<>());
    //     for (int i = 0; i < nums.length; i++) {
    //         int size = results.size();
    //         for (int j = 0; j < size; j++) {
    //             List<Integer> temp = new ArrayList<>(results.get(j));
    //             temp.add(nums[i]);
    //             results.add(temp);
    //         }
    //     }
    // }

    private void helperIterativeRecursion(int[] nums, int pivot, List<Integer> path) {
        // Base case
        if (pivot == nums.length + 1) {
            return;
        }

        // logic
        // results.add(path);
        results.add(new ArrayList<>(path));
        for (int i = pivot; i < nums.length; i++) {

            // without back tracking
            // List<Integer> li = new ArrayList<>(path);
            // li.add(nums[i]);
            // helperIterativeRecursion(nums, i + 1, li); // recursed

            path.add(nums[i]); // action
            helperIterativeRecursion(nums, i + 1, path); // recursed
            path.remove(path.size() - 1); // backtrack
        }

    }

    // private void helperRecursion(int[] nums, int idx, List<Integer> path) {
    //     // base
    //     if (idx == nums.length) {
    //         results.add(new ArrayList<>(path));
    //         return;
    //     }

    //     // Creates new li for choose path so no need to back track : Strategy one but
    //     // comes at additional space
    //     // List<Integer> li = new ArrayList<>(path);
    //     // li.add(nums[idx]);

    //     // creates new list for choose path and not choose path so no need to back track
    //     // : Strategy two but comes at additional space
    //     // Do not choose before addting to the path
    //     //// helperRecursion(nums, idx + 1, new ArrayList<>(path));

    //     // logic
    //     path.add(nums[idx]);

    //     // choose
    //     // helperRecursion(nums, idx + 1, li);
    //     //// helperRecursion(nums, idx + 1, new ArrayList<>(path));
    //     helperRecursion(nums, idx + 1, path);

    //     //

    //     // back Track
    //     path.remove(path.size() - 1);

    //     // dont choose
    //     // helperRecursion(nums, idx + 1, path);
    //     helperRecursion(nums, idx + 1, path);
    // }
}