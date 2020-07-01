//Time Complexity: O(2^N)
//Space Complexity: O(N* 2^N)

import java.util.*;

public class Subsets_recursive {
	List<List<Integer>> result;

	public List<List<Integer>> subsets(int[] nums) {
		result = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return result;
		helper(nums, new ArrayList<>(), 0);
		return result;
	}

	private void helper(int[] nums, List<Integer> temp, int i) {
		// base
		if (i == nums.length) {
			result.add(temp);
			return;
		}
		// logic
		// Don't Choose
		helper(nums, new ArrayList<>(temp), i + 1);
		// Choose
		temp.add(nums[i]);
		helper(nums, new ArrayList<>(temp), i + 1);
	}
}