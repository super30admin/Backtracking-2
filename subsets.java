package Backtracking2;
//Time Complexity : O(N* 2 ^ N) // at every node we can take 2 decisions.
//Space Complexity :O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no



public class subsets {
	class Solution {
	    List<List<Integer>> result;
	    public List<List<Integer>> subsets(int[] nums) {
	        result = new ArrayList<>();
	        if(nums == null || nums.length == 0) return result;
	        
	        backtrack(nums, 0, new ArrayList<>());
	        return result;
	    }
	    
	    private void backtrack(int[] nums, int index, List<Integer> path){
	        //base

	        result.add(new ArrayList<>(path));
	        //logic
	        //choose
	        for(int i=index; i<nums.length; i++){
	            path.add(nums[i]);
	            backtrack(nums, i+1, path);
	            path.remove(path.size() - 1);
	        }
	        
	    }
	}
}
