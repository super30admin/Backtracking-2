// Time Complexity : O(2^n). n is the number of elements in an array
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


class Solution {
    List<List<Integer>>list;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList();
        
        list=new ArrayList();
        
        backtrack(nums,new ArrayList(),0);
        return list;
    }
    
    private void backtrack(int[] nums,List<Integer> li,int start){
        
        list.add(new ArrayList(li));
        
        for(int i=start;i<nums.length;i++){
            //action
            li.add(nums[i]);
            
            //recursive
            backtrack(nums,li,i+1);
            
            //backtrack
            li.remove(li.size()-1);
            
        }
    }
}

