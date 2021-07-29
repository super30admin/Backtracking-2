// Time Complexity : o(exponential)
// Space Complexity : o(h) recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        result=new ArrayList<List<Integer>>();
        
        helper(nums,0,new ArrayList<Integer>());
        
        
        return result;
    }
    
    private void helper(int[] nums,int index,List<Integer> temp)
    {
        /*
        // one method is to to create new list of temp and pass to avoid deep list or pass existing list but after recursion every call decrement size-1 and store new list only to result.
        if(index==nums.length)
        {
            result.add(temp);
            return;
        }
        
        helper(nums,index+1,new ArrayList<>(temp));
        temp.add(nums[index]);
        helper(nums,index+1,new ArrayList<>(temp));
        
        */
        // another approach using recursion using temp list with out creating new one
        /*
        if(index==nums.length)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        // dont choose
        helper(nums,index+1,temp);
        // choose
        temp.add(nums[index]);
        helper(nums,index+1,temp);
        // remove last element
        temp.remove(temp.size()-1);
        */
        
        //Aproach using backtracking
        
        result.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++)
        {
            temp.add(nums[i]);
            helper(nums,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}