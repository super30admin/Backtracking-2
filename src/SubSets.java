// Time Complexity : recursive O(n*2^n), backtracking O(2^n)
// Space Complexity : recursive O(2^n), backtracking O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


public class SubSets {
	List<List<Integer>> res;
	public List<List<Integer>> subsets(int[] nums) {
		res = new ArrayList<>();

		if(nums == null || nums.length == 0) return res;

		helper(nums, new ArrayList<>(), 0);
		return res;
	}

	private void recursive(int[] nums, List<Integer> temp, int index) {

		//base
		if(index == nums.length){
			res.add(temp);
			return;
		}

		//logic
		//dont choose
		helper(nums, new ArrayList<>(temp), index+1);

		//choose
		temp.add(nums[index]);
		helper(nums, new ArrayList<>(temp), index+1);   
	}
	
	private void backtrack(int[] nums, List<Integer> temp, int index) {
	    
        //base
        if(index == nums.length){
            res.add(temp);
            return;
        }
        
        //logic
        //dont choose
        backtrack(nums, new ArrayList<>(temp), index+1);
        
        //choose
        temp.add(nums[index]);
        backtrack(nums, new ArrayList<>(temp), index+1); 
        temp.remove(temp.size()-1);
    }
}
