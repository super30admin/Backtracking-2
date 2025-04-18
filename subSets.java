// Time Complexity : O(2^N), where N is the length of nums
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Approach :
// Use backtracking to explore all combinations starting from each index (pivot)
// At each step, add the current subset to the result list
// Recursively add each remaining number and backtrack after exploring
// This builds all possible subsets including empty set and full array

import java.util.*;

public class subSets 
{
    public void helper(int pivot,int[] nums,List<List<Integer>> op,List<Integer> li)
    {
        op.add(new ArrayList<>(li));
        if(pivot<nums.length)
        {
            for(int i=pivot;i<nums.length;i++)
            {
                li.add(nums[i]);
                helper(i+1,nums,op,li);
                li.remove(li.size()-1);
            }
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        helper(0,nums,op,li);
        return op;
    }
}