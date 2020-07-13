// Time Complexity : O(n* 2^n) n is length of array
// Space Complexity :O(n* 2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        backtrack(0, new ArrayList<Integer>(),nums);
        return result;
        
    }
    
    private void backtrack(int index,  ArrayList<Integer> list, int[] nums){
        //base
        if(index==nums.length)
        {  
            result.add(new ArrayList<>(list));
            return;
        }
           
            //choose
            list.add(nums[index]);
            backtrack(index+1,list,nums);
            list.remove(list.size()-1);
            
            //dont choose
            backtrack(index+1,list,nums);
            
    }
}