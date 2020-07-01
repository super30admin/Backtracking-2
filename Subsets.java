/**
 * Time Complexity : O(n*2^n) where n = size of nums
 * Space Complexity : O(n*2^n)
 */

import java.util.*;
public class Subsets{
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        backtrack(nums,new ArrayList<>(),0);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> temp, int index){
        result.add(new ArrayList<>(temp));
        
        //logic
        for(int i=index;i<nums.length;i++){
            //action
            temp.add(nums[i]);
            
            //recurse
            backtrack(nums,temp,i+1);
            
            //backtrack
            temp.remove(temp.size()-1);
        }
    }

    /* Recursive Solution

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        recurse(nums,new ArrayList<>(),0);
        return result;
    }
    
    private void recurse(int[] nums, List<Integer> temp, int index){
        //base
        if(index == nums.length){
            result.add(temp);
            return;
        }
        
        //logic
        //dont choose
        recurse(nums,new ArrayList<>(temp),index+1);
      
        //choose
        temp.add(nums[index]);
        recurse(nums,new ArrayList<>(temp),index+1);
    }

    */
}