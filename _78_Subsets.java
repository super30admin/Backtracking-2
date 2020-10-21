package com.javadwarf.backtracking.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

	public static void main(String[] args) {
		System.out.println(new _78_Subsets().subsets(new int[] {1,2,3}));
	}

	List<List<Integer>> res = null;

	public List<List<Integer>> subsets(int[] nums) {
		res = new ArrayList<List<Integer>>();
		subsets(0,nums,new ArrayList<Integer>());
		return res;
	}

	public void subsets(int pos, int[] nums, List<Integer> temp) {

		res.add(new ArrayList<>(temp));

		for(int i=pos; i<nums.length; i++) {
			temp.add(nums[i]);
			subsets(i+1, nums, temp);
			temp.remove(temp.size()-1);
		}
	}
}
