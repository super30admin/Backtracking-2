import java.util.ArrayList;
import java.util.List;

//Time Complexity- exponential (2^n)
//Space Complexity- O(n)
//Sucessfully ran on leetcode-

class Solution {
    
 List<List<Integer>> result ;
 public List<List<Integer>> subsets(int[] nums) {
     
     if(nums.length==0 || nums == null) return result;
     result= new ArrayList<>();
     
     helper(nums, 0, new ArrayList<>());
     return result;
 }
 
 private void helper(int[] nums, int index, List<Integer> path){
     //base
     if(index== nums.length){
         result.add(new ArrayList(path));
         return;
     }
     //logic
     //case 0 not choose
     helper(nums, index+1, path);
     //case 1 choose
     
     //action
      path.add(nums[index]);
     
     //recurse
     helper(nums, index+1, path);
     
     //backtrack
     path.remove(path.size()-1);
 }
}