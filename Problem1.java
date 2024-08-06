import java.util.*;

// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * The strategy here is to keep adding the current element to the path
 * and keep moving forward. Since path here is a reference, we backtrack.
 * When we recurse, we start from the next index (pivot) [because we cannot repeat
 * the element].
 *
 * We can solve this without recursion as well. We start with an empty list in the result
 * list. At each iteration, we get the current snapshot (elements) in the result and
 * add the current element to every sublist. Notice that we are storing the result size
 * beforehand because we are adding to the result itself.
 */

public class Problem1 {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    //With Backtracking
    private void helper(int[] nums, int pivot, List<Integer> path) {
        //no base as recursion will stop at last index. For loop will take care of it.


        //logic
        res.add(new ArrayList<>(path)); //add at every node. Not just at the leaf
        for (int i = pivot; i < nums.length; i++) {
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i + 1, path);
            //backtrack
            path.removeLast();
        }

    }

    //Without Recursion
    public List<List<Integer>> subsetsWithoutRecursion(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(res.get(j)); //create a deep copy
                list.add(nums[i]);
                res.add(list);
            }
        }

        return res;
    }
}
