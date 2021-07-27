//Time Complexity : O(n*(2^n)), n -> Size of nums
// Space Complexity : O(n*(2^n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
	Set<List<Integer>> ans;
	int index;

	public List<List<Integer>> subsets(int[] nums) {
		ans = new HashSet<>();
		if (nums == null || nums.length == 0) {
			return new ArrayList<>(ans);
		}

		int n = nums.length;
		List<Integer> subset = new ArrayList<Integer>();
		ans.add(subset);
		for (index = 0; index <= n; index++) {
			findSubsets(nums, 0, n, subset);
		}
		return new ArrayList<>(ans);
	}

	/*************************************************************
	 * Backtrack after adding each element to check all combinations
	 *************************************************************/
	public void findSubsets(int[] nums, int start, int n, List<Integer> subset) {
		if (subset.size() == index) {
			ans.add(new ArrayList<Integer>(subset));
			return;
		}

		for (int i = start; i < n; i++) {
			subset.add(nums[i]);
			findSubsets(nums, i + 1, n, subset);
			subset.remove(subset.size() - 1);
		}
	}

	public static void main(String[] args) {
		Subsets obj = new Subsets();
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> ans = obj.subsets(nums);

		System.out.println("Set of subsets:");
		for (List<Integer> subset : ans) {
			for (Integer num : subset) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

}
