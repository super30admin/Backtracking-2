package s30Coding;

import java.util.*;
//Time Complexity :- O(n* 2^n)
//Space Complexity :- O(n)
//LeetCode :- Yes
//Logic :- backtracking
public class Subsets {

   
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        backtrack(nums,new ArrayList<>(),0);
        return result;
    }
    private void backtrack(int[] nums, List<Integer> temp, int index ){
        result.add(new ArrayList<Integer> (temp));
        for(int i = index;i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(nums,temp,i+1);
            temp.remove(temp.size() -1);
        }
    }
}
