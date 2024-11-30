// Time Complexity :O(2 pow n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int i, List<Integer> path){
        if(nums.length==i){
            res.add(new ArrayList<>(path));
            return;
        }

        //no choose case
        helper(nums,i+1,path);
        path.add(nums[i]);
        helper(nums,i+1,path);
        path.remove(path.size()-1);
    }
}
