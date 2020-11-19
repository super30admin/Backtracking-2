//Time Complexity : O(m^n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

import java.util.List;
import java.util.ArrayList;

public class Subsets_78 {
	// Recusrion with Backtracking
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0)
            return result;
        helper(nums, new ArrayList<>(), 0);
        return result;
    }
    private void helper(int[] nums, List<Integer> temp, int index)
    {
    	// Base
        result.add(temp);
    	// Logic
    	for(int i = index; i < nums.length; i++)
    	{
            // Action
    		temp.add(nums[i]);
            // Recurse
    		helper(nums, new ArrayList<>(temp), i+1);
            // Backtrack
            temp.remove(temp.size() - 1);
    	}
        
    }
//    // Iteration method
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        if(nums == null || nums.length == 0)
//            return result;
//        result.add(new ArrayList<>());
//        for(int num : nums)
//        {
//            int size = result.size();
//            for(int i = 0; i < size; i++)
//            {
//                List<Integer> temp = new ArrayList<>(result.get(i));
//                temp.add(num);
//                result.add(temp);
//            }
//        }
//        return result;
//    }
    
//	// Recursion with Do not choose first
//	
//    List<List<Integer>> result = new ArrayList<>();
//    public List<List<Integer>> subsets(int[] nums) {
//        if(nums == null || nums.length == 0)
//            return result;
//        helper(nums, new ArrayList<>(), 0);
//        return result;
//    }
//    private void helper(int[] nums, List<Integer> temp, int index)
//    {
//        // Base
//        if(index == nums.length)
//        {
//            result.add(new ArrayList<>(temp));
//            return;
//        }
//        // Logic
//        // Do not choose
//        helper(nums, new ArrayList<>(temp), index+1);
//        
//        // Choose
//        temp.add(nums[index]);
//        helper(nums, new ArrayList<>(temp), index+1);
//    }
    
//    // Recursion with Choose first
//	
//    List<List<Integer>> result = new ArrayList<>();
//    public List<List<Integer>> subsets(int[] nums) {
//        if(nums == null || nums.length == 0)
//            return result;
//        helper(nums, new ArrayList<>(), 0);
//        return result;
//    }
//    private void helper(int[] nums, List<Integer> temp, int index)
//    {
//        // Base
//        if(index == nums.length)
//        {
//            result.add(new ArrayList<>(temp));
//            return;
//        }
//        // Logic
//        // Choose
//        List<Integer> temp2 = new ArrayList<>(temp);
//        temp2.add(nums[index]);
//        helper(nums, temp2, index+1);
//        
//        // Do not choose
//        helper(nums, new ArrayList<>(temp), index+1);
//    }

//	// Recursion with for loop
//	
//    List<List<Integer>> result = new ArrayList<>();
//    public List<List<Integer>> subsets(int[] nums) {
//        if(nums == null || nums.length == 0)
//            return result;
//        helper(nums, new ArrayList<>(), 0);
//        return result;
//    }
//    private void helper(int[] nums, List<Integer> temp, int index)
//    {
//    	// Base
//    	result.add(temp);
//    	// Logic
//    	for(int i = index; i < nums.length; i++)
//    	{
//            List<Integer> temp2 = new ArrayList<>(temp);
//    		temp2.add(nums[i]);
//    		helper(nums, temp2, i+1);
//    	}
//    }
    
}
