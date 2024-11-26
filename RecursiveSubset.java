// Time Complexity : O(2^n). n is the number of elements in an array
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution {
    List<List<Integer>>list;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList();
        
        list=new ArrayList();
        
        helper(nums,new ArrayList(),0);
        return list;
    }
    
    private void helper(int[] nums,List<Integer> li,int index){
        
       if(index==nums.length){
           list.add(new ArrayList(li));
           return;
       }
        
        helper(nums,new ArrayList(li),index+1);
        li.add(nums[index]);
        helper(nums,new ArrayList(li),index+1);
            
        }
    
}
