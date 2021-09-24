// Time Complexity : O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : not sure about space complexity


// Your code here along with comments explaining your approach
//1 using recursion in for loop
//2. for example [1,2,3] :- [] first call for first element of entire list i.e [1] dive deep for its  first child i.e  2 add to list [1,2] 
dive deep for child of [1,2] i.e 3 and add to list [1,2,3] get back to [1] dive deep for second child i.e 3 add it to list [1,3] back to [1] next elemnt in [2] dive deep for its child i.e 3 add it [2,3] get back next element is 3 add it [3] end of the forloop.


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
      
        helper(nums,0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums,int pivot, List<Integer> currSet)
    {
        //base
        result.add(new ArrayList<>(currSet));
            
      
        // logic
       for(int i = pivot; i<nums.length; i++ )
       {
           //action
             currSet.add(nums[i]);
           //recursion
             helper(nums,i+1,currSet);
           
         //  backtracking
             currSet.remove(currSet.size()-1);
        
       }
    }
}


