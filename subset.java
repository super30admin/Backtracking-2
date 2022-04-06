/*
Time Complexity : O(2 ^N) where n is the length of the string.
Space Complexity :  O(n) here n is the number of elements in the recursive stack.

*/


import java.util.*;
class Solution {
    List<List<Integer>> result =  new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList());
        backtrack(nums,0,new ArrayList());
        return result;
    }
    public void backtrack(int nums[], int index,List<Integer> list)  {
      
       
       
        if(list.size() >= nums.length) {
            
              
            return;
        }
        
    for(int i  = index; i<nums.length; i++) {
        
        list.add(nums[i]);
         result.add(new ArrayList(list));
      
        backtrack(nums,i+1,list);
        
       list.remove(list.size()-1);
       
        
    } 
         
        }
        
    }
