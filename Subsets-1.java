/*
Author: Akhilesh Borgaonkar
Problem: Given a set of distinct integers, nums, return all possible subsets.
Approach: Used backtracking here. Performed exhaustive recursion call with the base condition i.e. if current index is last literal in the input string.
    If yes then, add it to result list else remove from list. Also, appended empty set at the very start.
Time Complexity: O(2^n)
Space Complexity: O(n)
*/

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0, new ArrayList<Integer>());
        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] nums, int index, List<Integer> temp){
        result.add(new ArrayList<Integer>(temp));

        //base condition
        if(index == nums.length)
            return;

        for(int i=index; i<nums.length; i++){
            temp.add(nums[i]);
            backtrack(result, nums, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }

}

