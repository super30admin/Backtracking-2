// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        
        
        if(nums.length==0 || nums==null){
            return result;
        }
        
        List<Integer> l1=new ArrayList<>();
        
        helper(nums,l1,0);
        return result;
        
    }
    
    
    private void helper(int[] nums, List<Integer> l1, int startIndex){
        
        result.add(new ArrayList<>(l1));
        
        for(int i=startIndex;i<nums.length;i++){
            l1.add(nums[i]);
            helper(nums,l1,i+1);
            l1.remove(l1.size()-1);
        }
        
        
    }
    
}