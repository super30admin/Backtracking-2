//Time Complexity: O(2^N)
//Space Complexity: O(N)

import java.util.*;

public class SubSets_Backtracking {
	class Solution {
		List<List<Integer>> result;

		public List<List<Integer>> subsets(int[] nums) {
			result = new ArrayList<>();
			if (nums == null || nums.length == 0)
				return result;
			backtrack(nums, new ArrayList<>(), 0);
			return result;
		}

		private void backtrack(int[] nums, List<Integer> temp, int start) {
			// base
			// logic
			result.add(new ArrayList<>(temp));
			for (int i = start; i < nums.length; i++) {
				// action
				temp.add(nums[i]);
				// recurse
				backtrack(nums, temp, i + 1);
				// backtrack
				temp.remove(temp.size() - 1);
			}
		}
	}
}