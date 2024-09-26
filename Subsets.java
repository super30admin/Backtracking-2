

// Time Complexity : Exponential
// Space Complexity : Exponential
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


import java.util.*;

public class Subsets {
	List<List<Integer>> res;

	private List<List<Integer>> subsets(int[] nums) {

		if (nums == null || nums.length == 0)
			return res;
		
		res = new ArrayList<>();

		backTrack(nums, new ArrayList<>(), 0);

		for (List<Integer> l : res) {
			System.out.println(l);
		}

		return res;

	}

	private void backTrack(int[] nums, List<Integer> temp, int index) {

		if (index > nums.length)
			return;

			res.add(new ArrayList<>(temp));
		for (int i = index; i < nums.length; i++) {

			temp.add(nums[i]);
			backTrack(nums, temp, i + 1);
			temp.remove(temp.size() - 1);

		}
	}

	public static void main(String[] args) {
		Subsets s = new Subsets();
		s.subsets(new int[] { 1, 2, 3, 4 });

	}

}
