import java.util.*;

// Time Complexity : O(n * 2^n) — there are 2^n subsets; building each subset costs up to O(n).
// Space Complexity : O(n) auxiliary for the recursion stack and current path (excluding the output).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Approach (Backtracking: include/exclude):
// - At each index, we have two choices: include nums[index] or skip it.
// - When index reaches nums.length, we add a COPY of the current path to result.
// - We mutate a single `path` list with add/remove (backtrack) to avoid extra allocations.

class Subsets {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        // Base case: formed one subset
        if (index == nums.length) {
            result.add(new ArrayList<>(path)); // add a COPY
            return;
        }

        // Choice 1: include nums[index]
        path.add(nums[index]);
        helper(nums, index + 1, path);

        // Backtrack (undo the include)
        path.remove(path.size() - 1);

        // Choice 2: exclude nums[index]
        helper(nums, index + 1, path);
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        Subsets sol = new Subsets();

        int[] nums1 = {1, 2, 3};
        List<List<Integer>> res1 = sol.subsets(nums1);
        System.out.println("Subsets of [1, 2, 3]:");
        print(res1);

        int[] nums2 = {0};
        List<List<Integer>> res2 = sol.subsets(nums2);
        System.out.println("\nSubsets of [0]:");
        print(res2);

        int[] nums3 = {};
        List<List<Integer>> res3 = sol.subsets(nums3);
        System.out.println("\nSubsets of []:");
        print(res3);
    }

    private static void print(List<List<Integer>> lists) {
        for (List<Integer> l : lists) {
            System.out.println(l);
        }
    }
}
