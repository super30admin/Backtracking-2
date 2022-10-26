// TC : 2^n
// SC : 2^n
// Ran on LC : Yes
// Problems : None.

class Solution {
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