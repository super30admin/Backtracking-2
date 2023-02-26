import java.util.ArrayList;
import java.util.List;
//Time Complexity : O(2^N)
//Space Complexity : O(N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Iterate over each index of the array push that number to the list and add
 * that list to the final list. then apply backtracking on the remaining array.
 * push the list to final list only when index crosses length of the array. Once
 * that is done, remove the last added element from the list and apply
 * backtracking on the remaining numbers.
 *
 */
class Solution {
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		// ans.add(new ArrayList<>());
		helper(nums, 0, new ArrayList<>());
		return ans;
	}

	public void helper(int[] nums, int start, List<Integer> list) {
		if (start >= nums.length) {
			ans.add(new ArrayList<>(list));
			return;
		}
		list.add(nums[start]);
		helper(nums, start + 1, list);
		list.remove(list.size() - 1);
		helper(nums, start + 1, list);
	}

	public void helper2(int[] nums, int start, List<Integer> list) {
		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			ans.add(new ArrayList<>(list));
			helper2(nums, i + 1, list);
			list.remove(list.size() - 1);
		}
	}
}

public class SubSets {

}
