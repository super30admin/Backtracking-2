// Time Complexity:O(2^n)
// Space Complexity: 
// Did this code successfully run on Leetcode: 
// Any problem you faced while coding this:


// Your code here along with comments explaining your approach
/*
 * Approach 1 -> Brute Force 0-1 Recursion
 */

import java.util.ArrayList;

public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        if(nums.length == 0)
            return result;
        
        helper(nums,0,new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int i, List<Integer> path)
    {
        //base
        if(i == nums.length)
        {
            result.add(path);
            return;
        }
        //logic
            //not choose
        helper(nums,i+1,new ArrayList<>(path));
        
            //choose
        path.add(nums[i]);
        helper(nums,i+1,new ArrayList<>(path));
    }
}

/*
 * Approach 2 - Using backtracking 0-1 recursion
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        if(nums.length == 0)
            return result;
        
        helper(nums,0,new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int i, List<Integer> path)
    {
        //base
        if(i == nums.length)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
            //not choose
        helper(nums,i+1,path);
        
            //choose
        //action
        path.add(nums[i]);
        //recurse
        helper(nums,i+1,path);
        //backtrack
        path.remove(path.size() - 1);
    }
}

/*
 * Approach 3 - Using For Loop Based 0-1 Recursion 
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        if(nums.length == 0)
            return result;
        
        helper(nums,0,new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path)
    {
        //base
        
        result.add(path);
        //logic 
        for(int i = index;i<nums.length;i++)
        {
            //action
            List<Integer> temp = new ArrayList<>(path);
            temp.add(nums[i]);
            
            //recurse
            helper(nums,i+1,temp);
        }
    }
}

/*
 * Approach 4 - Without recursion in the same time complexity
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        for(int i = 0; i < nums.length;i++)
        {
            int size = result.size();
            for(int j = 0; j < size; j++)
            {
                List<Integer> temp = new ArrayList(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}