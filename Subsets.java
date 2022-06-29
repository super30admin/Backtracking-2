import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<>(path));
        for(int i = idx; i<nums.length; i++){
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i+1, path, result);
            path.remove(path.size()-1);
            
        }
    }
}