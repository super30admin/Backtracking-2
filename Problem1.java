package Backtracking_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Using choose-no choose based recursion and also for loop based recursion to
 * solve the problem.
 * 
 * Time Complexity : O(2^(n))- where n is the no of values.
 * 
 * Space Complexity : O(n), actually is the height of the tree which accounts
 * for recursive stack space.
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        // helper(nums,0,new ArrayList<>(),result);
        forLoopRecursion(nums,0,new ArrayList<>(),result);
        result.add(new ArrayList<>());
        return result;
    }

    void helper(int[] nums, int idx,List<Integer> path,List<List<Integer>> result){
        //base
        if(idx==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
            
        //logic
        //choose
        path.add(nums[idx]);
        helper(nums,idx+1, path, result);
        path.remove(path.size()-1);

        //not choose
        helper(nums,idx+1, path, result);

    }
 void forLoopRecursion(int[] nums, int pivot,List<Integer> path,List<List<Integer>> result){

     //logic
     for(int i=pivot;i<nums.length;i++){
         path.add(nums[i]);
         result.add(new ArrayList<>(path));
         forLoopRecursion(nums,i+1,path, result);
         path.remove(path.size()-1);
     }

 }
}
