// Time Complexity : exponential 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result= new ArrayList<>();
        
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums,int index,List<Integer> path){ //path is ur subset
        //base case
        
        result.add(new ArrayList<>(path));
        if(index==nums.length){ 
           
            return;
        }   
        //logic
        
        
        
        
        //0 case not choose
        helper(nums,index+1,path);
        
        //1 case choose case 
        path.add(nums[index]);
        helper(nums,index+1,path);
        
        
        //backtracking
        path.remove(path.size()-1);
        
    }
}