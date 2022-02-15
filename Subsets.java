// tc: O(N*2^N) where N is length of input array
// sc: O(N) where N is length of input array

import java.util.*;
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, int idx, List<Integer> path){
        //logic
        res.add(new ArrayList(path));
        for(int i=idx; i<nums.length; i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}