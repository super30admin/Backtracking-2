//TC : O(2^N) 
 //SC : O(N) // where N is the max stack size of the recurrsion  
 //run successfully on Leetcode 
 //no problems in solving

 //picked up every num and went through all the possibilities of 
 //choose and dont choose; i used here global variables for the list of list
 

import java.util.*;

class Sunsets {
    List<List<Integer>> result;
    int cnt;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        //helper(nums, 0, path);
        backtrack(nums, 0, path);
        return result;
    }

    public void helper(int[] nums, int index, List<Integer> path){
        //base
        if (index >= nums.length) {
            result.add(path);
            return;
        }
        //logic
        //Dont choose
        helper(nums, index+1, path);
        // choose
        List<Integer> li = new ArrayList<>(path);
        li.add(nums[index]);
        helper(nums, index+1, li);
    }

    private void backtrack(int[] nums, int index, List<Integer> path){
    result.add(new ArrayList<>(path));
    for(int i = index; i < nums.length; i++){
        path.add(nums[i]);
        System.out.println("Before "+path);
        backtrack(nums, i + 1, path);
        System.out.println("After "+path);
        path.remove(path.size() - 1);
    }
}
}