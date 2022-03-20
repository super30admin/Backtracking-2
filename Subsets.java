import java.util.*;
// Time Complexity : O(2^n) where n is the size of the nums array.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    // no recursion
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        // null check
        if (nums.length == 0)
            return result;
        result.add(new ArrayList());
        for (int i = 0; i < nums.length; i++) {
            int k = result.size();
            for (int j = 0; j < k; j++) {
                List<Integer> temp = new ArrayList(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }

}