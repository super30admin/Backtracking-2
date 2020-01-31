package com.exmaple.problems;

import java.util.*;

//Time Complexity : O(N * 2^N)

//Space Complexity : O(2^N) for Both Approaches
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
/*
* Backtracking Approach is used for exploring all possibilities for powerset.
* Also There is Bitiwse approach for powerset.It is not a signigicant improvement over backtracking .
* But it is faster then backtracking for larger numbers
Bitwise operations are used mostly in resources (memory) constrained environment
* 
* We have solved problem using visited array and local variable.Use of visited array increases space and time complexity. 
* */
public class PowerSet {
	private static boolean isBackTracking = false;
	List<List<Integer>> output = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		if (isBackTracking) {
			backtrack(new ArrayList<>(), nums, 0);
		} else {
			bitwise(nums);
		}
		return output;
	}

	private void bitwise(int nums[]) {
		Set<List<Integer>> set = new HashSet<>();
		int size = nums.length;
		int poss = 1 << size; // Bitwise Notation for 2^N

		for (int i = 0; i < poss; i++) {
			List<Integer> li = new ArrayList<>();
			for (int j = 0; j < size; j++) {
				// Bitwise Notation for 2^N
				if ((i & (1 << j)) == 0) {
					li.add(nums[j]);
				}
			}
			if (!set.contains(li)) {
				output.add(li);
			}
			set.add(li);
		}
	}

	private void backtrack(List<Integer> tempList, int[] nums, int start) {
		if (start > nums.length)
			return;
		output.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String args[]) {
		int nums[] = { 1, 2, 2 };
		System.out.println(new PowerSet().subsets(nums));
	}
}
