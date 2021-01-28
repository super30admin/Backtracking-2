//Problem 72: Subsets
//Time Complexity: O(something*2^N), which is exponential. N stands for input array length
//Space Complexity : O(N), because I'm using a current path list for storing current elements on each recursive call; 

/*Steps

   1) Bruteforce:   TC:O(something*2^N) | SC:O(N*2^N), because each time I'm copying existing current path to new list
      Basically I have to choose the element or not. On each recursive call, I copied my current path list to two new list called op1  & op2. Then if I'm chosing the element then I added it into op1 and passed it with the recursive call.Otherwise, if I'm not chosing the current element I simply passed my op2 along with index+1.

      If index ==nums.length then I just added the current path in my final result and returned
      
    2) Optimal : //TC:O(something*2^N) | SC:O(N);
       Similar to above, just use 'for loop' for iterating from start to end of the input array and making the recursive call. It helps in optimizing space complexity. Now no need to copy current path to new list on each recursive call. Only copy the current path into result list when target==0; 

       Note: Here TC: 2^N because we are making 2 decisions at every recursive call.
*/

import java.util.*;

class Solution72 {
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        
        res = new ArrayList<>();
        
        if(nums==null || nums.length==0) return res;
        
        //With For Loop
        //TC:O(2^N) | SC:O(N)
        //helper(nums,new ArrayList<>(),0);
        
        //Without For loop
        //TC:O(2^N) | SC:O(N)
        helperBacktrack(nums,new ArrayList<>(),0);
        
        //Bruteforce - TC:O(2^N) | SC:O(N^2)
        //helperRecursive(nums,new ArrayList<>(),0);
        
        return res;
    }
    
    //With For Loop
    /*private void helper(int[] nums, List<Integer> currPath,int start){
        
        //base
        if(start>nums.length){
          return;  
        }
        
        res.add(new ArrayList<>(currPath));
        
        for(int i=start;i<nums.length;i++){
            
            currPath.add(nums[i]);
            helper(nums,currPath,i+1);
            currPath.remove(currPath.size()-1);
        }
        
    }*/
    
    //Without For Loop
    private void helperBacktrack(int[] nums, List<Integer> currPath,int idx){
        
        //base
        if(idx==nums.length){
          res.add(new ArrayList<>(currPath));
          return;  
        }
        
        //logic
        
        //choose
        currPath.add(nums[idx]);
        helperBacktrack(nums,currPath,idx+1);
        //backtrack action
        currPath.remove(currPath.size()-1);
        
        //not choose
        helperBacktrack(nums,currPath,idx+1);
        
    }
    
    //Bruteforce Recursion
    /*private void helperRecursive(int[] nums, List<Integer> currPath,int idx){
        
        //base
        if(idx==nums.length){
          res.add(currPath);
          return;  
        }
        
        //logic
        List<Integer> op1 = new ArrayList<>(currPath);
        List<Integer> op2 = new ArrayList<>(currPath);
        
        //choose
        op1.add(nums[idx]);
        helperRecursive(nums,op1,idx+1);
        
        //not choose
        helperRecursive(nums,op2,idx+1);
        
    }*/
    
}