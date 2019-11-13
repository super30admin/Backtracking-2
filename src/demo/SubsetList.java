package demo;

import java.util.ArrayList;
import java.util.List;

//TIme : O(2^n)
//Space: 0(n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums.length == 0) return result;
        helper(nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void helper(int[] nums, List<Integer> temp, int start){
        //base case - every time we want backtracking function to be called will add the temp list into the result
        result.add(new ArrayList<>(temp));
        for(int i =start; i < nums.length; i++){
            temp.add(nums[i]);
            helper(nums, temp, i+1);
            temp.remove(temp.size()-1); //backtracking happening
        }
    }
}