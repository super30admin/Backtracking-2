// Time Complexity : O(n 2^n), n - no of elements
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * choose not choose approach - not choose does not make any changes to the path.
 * BUt before choose , we have to create a sublist of path reference and then add new number to it and pass it to the helper function for next recursive call
*/
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] nums, int idx, List<Integer> path) {
        // base
        if (idx == nums.length) {
            result.add(path);
            return;
        }

        // logic

        // not choose
        helper(nums, idx + 1, path);

        // choose

        List<Integer> sublist = new ArrayList<>(path);
        sublist.add(nums[idx]);
        helper(nums, idx + 1, sublist);
    }
}

// backtracking

// Time Complexity : O(n 2^n), n - no of elements
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using the backtrack approach, we add and remove the unwanted number from the
 * same path list.
 * It reduces the need of creating a new Array list for every level.
 */
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] nums, int idx, List<Integer> path) {
        // base
        if (idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic

        // not choose
        helper(nums, idx + 1, path);

        // choose
        path.add(nums[idx]);
        helper(nums, idx + 1, path);
        path.remove(path.size() - 1);
    }
}

// backtracking based for loop approach,

// Time Complexity : O(2^n), n - no of elements
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using the backtracking based for loop approach, MOve from pivot to the end of
 * the array.
 * While calling the helper function we call the i varibale not pivot bcoz pivot
 * is stationary and i is moving in the for loop based approach
 */
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path) {
        // base
        result.add(new ArrayList<>(path));

        // logic
        // choose
        for (int i = pivot; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i + 1, path);
            path.remove(path.size() - 1);
        }

    }
}

// forloop based

// Time Complexity : O(2^n), n - no of elements
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using the for loop based approach, MOve from pivot to the end of the array.
 * While calling the helper function we call the i varibale not pivot bcoz pivot
 * is stationary and i is moving in the for loop based approach
 */
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path) {
        // base
        result.add(path);

        // logic
        // choose
        for (int i = pivot; i < nums.length; i++) {
            List<Integer> sublist = new ArrayList<>(path);
            sublist.add(nums[i]);
            helper(nums, i + 1, sublist);
        }

    }
}

// Iterative approach

// Time Complexity : O(2^n), after every index the no. of solutions double
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * create a result list with empty sublist.
 * for every element in the nums array, add it to the sublist considering the
 * previous element from the result list.
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> sublist = new ArrayList<>(result.get(j));
                sublist.add(nums[i]);
                result.add(sublist);
            }
        }

        return result;
    }
}