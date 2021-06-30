// Time Complexity : O(N* 2 POW N) // at every node we can take 2 decisions.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


/*
 * 1. create a empty list and add it to result
 * 2. for each element in the array copy result and add element to each list and add it to result. 
 */

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	List<List<Integer>> result;

	public List<List<Integer>> subsets(int[] nums) {
		result = new ArrayList<>();
		result.add(new ArrayList<>());
		if (nums.length == 0)
			return result;
		helper(nums, 0);
		
		return result;
	}

	private void helper(int[] nums, int index) {
		if (index >= nums.length)
			return;

		int ele = nums[index];
		
		int len=result.size();
		for (int i=0;i<len;i++) {
			List<Integer> newList = new ArrayList<>(result.get(i));
			newList.add(ele);
			result.add(newList);
		}
		helper(nums, index + 1);

	}

	public static void main(String[] args) {
		new Subsets().subsets(new int[] { 1, 2, 3 });
	}
}
