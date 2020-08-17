import java.util.ArrayList;
import java.util.List;

//Approach: Backtracking

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        backtrack(nums, new ArrayList<>() , 0);
        return result;
    }
    private void backtrack(int[] nums, List<Integer> list, int pos)
    {
        //base
            
        for(int i=pos;i<=nums.length;i++)
        {
            if(i == nums.length)
            {
                result.add(new ArrayList<>(list));
                return;
            }
            //action
            list.add(nums[i]);
            //recursion call
            backtrack(nums, list, i+1);  
            //backtrack by removing what we added
            list.remove(list.size()-1);
        }
         
    }
}
//Time Complexity : O(2 ^ n)  
//Space Complexity : O(n )   
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

//Approach: Recursion

class Solution1 {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        helper(nums, new ArrayList<>() , 0);
        return result;
    }
    private void helper(int[] nums, List<Integer> list, int pos)
    {
        //base
        if(pos == nums.length)
        {
            result.add(list);
            return;
        }    
            
        //action
       
        //dont choose
        helper(nums, new ArrayList<>(list), pos+1);
        //choose
        list.add(nums[pos]);
        helper(nums, new ArrayList<>(list), pos+1);   
    }
}

//Time Complexity : O(2 ^ n) 
//Space Complexity : O(n)  
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :