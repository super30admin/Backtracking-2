package backtracking2;

//Idea: We choose from any element recursively. Every time we add an integer from nums array 
//		to our possible subset result, we increment the start pointer by 1.

// TC: O(2^n) where n is the length of nums array
// SC: O(n*2^n) because n is the length of the array and 2^n is the space occupied by 
//				recursive combinations of subsets.

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums == null) return result;
        backtracking(nums, result, new ArrayList<>(), 0);
        
        return result;
    }
    
    public void backtracking(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
       result.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++) {
            temp.add((nums[i]));
            
            backtracking(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1); // remove the last element in the temp so that it can go back one level.
        }
        
    }
}
