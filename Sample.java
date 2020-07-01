// Time Complexity : O(n*2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : yes		
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


//recursion
class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        
        backtrack(nums, new ArrayList<>() , 0);
        return result;
    }
    
    private void backtrack(int[] nums , List<Integer> temp , int start){
        
        //base
        if(start == nums.length){ 
            result.add(temp);
            return;
        }
        //logic 
       // result.add(new ArrayList<>(temp));
       // dont choose  
        backtrack(nums,new ArrayList<>(temp),start+1);
        //choose
        temp.add(nums[start]);
        backtrack(nums,new ArrayList<>(temp),start+1);
        
    }
}


// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes		
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        
        backtrack(nums, new ArrayList<>() , 0);
        return result;
    }
    
    private void backtrack(int[] nums , List<Integer> temp , int start){
        
        //base
        
        
        
        //logic 
        result.add(new ArrayList<>(temp));
        
        for(int i = start ; i < nums.length ; i++){
            
            //action
            temp.add(nums[i]);
            //recurse
            backtrack(nums, temp, i+1);
            //backtrack
            temp.remove(temp.size() -1 );
            
        }
        
        
        
    }
}




