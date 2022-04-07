import java.util.ArrayList;
import java.util.List;

/**
 * time complexity is exponential - O(2^N)
 * space complexity is exponential - O(2^N)
 */

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> set) {
        if(index <= nums.length) {
            result.add(new ArrayList<>(set));
            
            for(int i = index; i < nums.length; i++) {
                set.add(nums[i]);
                helper(nums, i+1, set);
                set.remove(set.size()-1);
            }
        }
    }
}