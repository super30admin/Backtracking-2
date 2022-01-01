import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(2^n) at every recursive step we have two decisions , and recursion continues till n , n being the length of the array
// Space Complexity :O(n) maximum calls in the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach
class Solution {
    //Backtracking 0/1 chase
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        result= new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        
        return result;
    }
    
    private void helper(int [] nums, int index, List<Integer> path){
        
        //base case
        if(index==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        //case0
         helper(nums,index+1,path);
        //case1
        path.add(nums[index]);
        helper(nums,index+1,path);
        path.remove(path.size()-1);
    }

     //Recursiion- Recursive Iterative Technique
     List<List<Integer>> result1;
     public List<List<Integer>> subsets1(int[] nums) {
         
         result1= new ArrayList<>();
         helper1(nums,0,new ArrayList<>());
         
         return result;
     }
     
     private void helper1(int [] nums, int index, List<Integer> path){
 
         //base
         
         result1.add(path);
         //logic
         for(int i=index;i<nums.length;i++){
             
             List<Integer> newList= new ArrayList<>(path);
             newList.add(nums[i]);
             helper(nums,i+1,newList);
         }
     }
}