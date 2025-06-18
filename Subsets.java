// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : using for loop based recursion. Here we'll have 2 pointers in recursive function, pivot and i. Pivot is parameter
// of recursion and i iterates from pivot to end of string. In i loop, we keep adding ith index and call recursion with pivot = i+1

import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void helper(int nums[], int pivot, ArrayList<Integer> path, List<List<Integer>> result){
        //base
        if(pivot > nums.length){
            return;
        }
        result.add(new ArrayList<Integer>(path));
        //logic
        for(int i=pivot;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums, i+1, path, result);
            path.remove(path.size()-1);
        }
    }
}