// Subsets (https://leetcode.com/problems/subsets/)

// Time Complexity: O(2^n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

import java.util.ArrayList;
import java.util.List;

public class subsetsForLoopRec {
    static List<List<Integer>> res;

    public static List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        // Null case
        if (nums == null)
            return res;
        // recurssion
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    private static void helper(int[] nums, int index, List<Integer> path) {

        // Action
        res.add(path);

        // Recurse
        for (int i = index; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>(path);
            temp.add(nums[i]);
            helper(nums, i + 1, temp);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println((subsets(nums)));
        // output: [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
    }
}
