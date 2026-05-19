// Time Complexity :  O(2^n * n) where n is the number of elements in the input array. This is because we are generating all possible subsets, which is 2^n, and for each subset, we are creating a new list which takes O(n) time in the worst case.
// Space Complexity : O(n) where n is the number of elements in the input array. This is because in the worst case, we will have a subset that contains all the elements of the input array, which will take O(n) space to store.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will use backtracking to find all the possible subsets of the input array.
// We will start from the first element and keep adding elements to the current path until we reach the end of the array.
// We will add the current path to the result list at each step, and then backtrack by removing the last element from the path and continue to find the next subset.
// The time complexity of this solution is O(2^n * n) because in the worst case, we will have to explore all possible combinations of subsets, which is 2^n, and for each combination, we will create a new list to store the subset, which takes O(n)
import java.util.*;

class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {

        res = new ArrayList<>();

        helper(nums, 0, new ArrayList<>());

        return res;
    }

    private void helper(int[] nums,
                        int indx,
                        List<Integer> path) {

        // Add current subset
        res.add(new ArrayList<>(path));

        for (int i = indx; i < nums.length; i++) {

            path.add(nums[i]);

            helper(nums, i + 1, path);

            // backtrack
            path.remove(path.size() - 1);
        }
    }
}