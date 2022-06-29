// Time Complexity : O(n* 2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    private static List<List<Integer>> result;

    // approch 1
    public static List<List<Integer>> subsets1(int[] nums) {
        result = new ArrayList<>();
        // null case
        if (nums.length == 0)
            return result;
        helper1(0, nums, new ArrayList<>());
        return result;

    }

    private static void helper1(int ind, int[] nums, List<Integer> path) {
        // base case
        if (ind == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // main logic
        // case 1 not choose
        // after not choosing the element I will move forward by one pointer
        helper1(ind + 1, nums, path);
        // case 2 choose
        // after choosing the element I will also move forward by one pointer
        // add this element to the path
        path.add(nums[ind]);
        helper1(ind + 1, nums, path);
        // backtrack
        path.remove(path.size() - 1);
    }

    // approch 2
    public static List<List<Integer>> subsets2(int[] nums) {
        result = new ArrayList<>();
        // null case
        if (nums.length == 0)
            return result;
        helper2(0, nums, new ArrayList<>());
        return result;

    }

    // for loop based recursion
    private static void helper2(int ind, int[] nums, List<Integer> path) {
        // here I do not need base case as it will handled by the for loop
        // here first I will add path to the result
        result.add(new ArrayList<>(path));
        // for loop from pivot to end of the list
        for (int i = ind; i < nums.length; i++) {
            // after choosing the element I will one pointer ahead
            path.add(nums[i]);
            // calling recursion
            helper2(i + 1, nums, path);
            // backtrack
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        System.out.println(subsets1(nums));
        System.out.println(subsets2(nums));
    }
}