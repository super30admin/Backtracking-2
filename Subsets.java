// Time Complexity :O(N^2)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        helper(nums,0,result,new ArrayList<>());

        return result;
    }

    public void helper(int[] nums,int i,List<List<Integer>> result,List<Integer> li)
    {
        if(i==nums.length)
        {
            result.add(new ArrayList<>(li));
            return;
        }
    
        li.add(nums[i]);
        helper(nums,i+1,result,new ArrayList<>(li));
        li.remove(li.size()-1);
        helper(nums,i+1,result,new ArrayList<>(li));

    }
}
   