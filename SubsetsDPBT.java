// Time Complexity : O(N* 2 POW N) // at every node we can take 2 decisions.
// Space Complexity :O(N) //temporary array which we are making a copy to add it to result
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


/*
 * 1. DP for loop with backtracking 
 * 2. Select each element and go to next element and find all possible combinations and add it to result.
 * 3. move to next element till all elements are completed. 
 */

import java.util.ArrayList;
import java.util.List;

public class SubsetsDPBT {
	List<List<Integer>> result;

	public List<List<Integer>> subsets(int[] nums) {
		result = new ArrayList<>();
		if (nums.length == 0)
			return result;
		helper(nums, 0,new ArrayList<>());
		
		for (List<Integer> list : result) {
			System.out.println(list);
		}
		return result;
	}

	private void helper(int[] nums, int index,List<Integer> sublist) {
		result.add(new ArrayList<>(sublist));
		
		for(int i=index; i<nums.length;i++) {
			//action
			sublist.add(nums[i]);
			//recur
			helper(nums,i+1,sublist);
			//backtrack
			sublist.remove(sublist.size()-1);
		}

	}

	public static void main(String[] args) {
		new SubsetsDPBT().subsets(new int[] { 1, 2, 3 });
	}
}
