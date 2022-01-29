package backtracking2;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	//Time Complexity : O(2^n), where n is length of nums
	//Space Complexity : O(n), for internal stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        res.add(path);
        helper(nums, res, 0, path);
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, int idx, List<Integer> path) {
        for(int i=idx; i<nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            helper(nums, res, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
    
    //Time Complexity : O(2^n), where n is length of nums
  	//Space Complexity : O(n), for internal stack
  	//Did this code successfully run on Leetcode : Yes
  	//Any problem you faced while coding this : No
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper1(nums, res, 0, new ArrayList<>());
        return res;
    }
    
    private void helper1(int[] nums, List<List<Integer>> res, int idx, List<Integer> path) {
        // null
        if(idx == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        // logic
        // choose
        path.add(nums[idx]);
        helper1(nums, res, idx + 1, path);
        path.remove(path.size() - 1);
        
        // don't choose
        helper1(nums, res, idx + 1, path);
    }
    
    //Time Complexity : O(2^n), where n is length of nums
  	//Space Complexity : O(1)
  	//Did this code successfully run on Leetcode : Yes
  	//Any problem you faced while coding this : No
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        
        for(int i=0; i<nums.length; i++) {
            int k = res.size();
            for(int j=0; j<k; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        
        return res;
    }
}
