/* 
Time Complexity: O(n * 2^n)
   - There are 2^n subsets; copying the current path into the result costs up to O(n) each.

Space Complexity: O(n)
   - Recursion depth and path size up to n (excluding the output which is O(n * 2^n))

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// 1. Backtrack over index i. At each index, branch into:
//    - Not choosing nums[i].
//    - Choosing nums[i] (push, recurse, then pop).
// 2. When i == n, add a copy of path to result.
// 3. Classic include/exclude recursion enumerates all subsets.


import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int i, List<Integer> path){
        if(i == nums.length){
            result.add(new ArrayList<>(path)); // copy only for output
            return;
        }

        //no choose
        helper(nums, i + 1, path);

        //choose
        path.add(nums[i]);
        helper(nums, i + 1, path);
        path.remove(path.size() - 1);
    }
}
