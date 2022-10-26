// Problem1 - https://leetcode.com/problems/subsets/

// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

public class problem1 {
	public List<List<Integer>> subsets(int[] nums) {
		 List<List<Integer>> list = new ArrayList<>();
		 Arrays.sort(nums);
		 helper(list, new ArrayList<>(), nums, 0);
		 return list;
	}
	
	private void helper(List<List<Integer>> list , List<Integer> temp, int [] nums, int start){
		 list.add(new ArrayList<>(temp));
		 for(int i = start; i < nums.length; i++){
			  temp.add(nums[i]);
			  helper(list, temp, nums, i + 1);
			  temp.remove(temp.size() - 1);
		 }
	}
}
