// Time Complexity : O(2^n * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    List<List<Integer> > result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        helper(0, new ArrayList<>(), nums);
        return result;
    }
    
    private void helper(int index, List<Integer> path, int[] nums) {
        if (index == nums.length) {
            return;
        }
        
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            helper(i + 1 , path, nums);
            path.remove(path.size() - 1);
        }
    }
}