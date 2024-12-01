/*
backtracking approach
 * Tc - o(n*2^n)
 * Sc - o(n) 
 * 
 * Approach - we have a start pointer and we add the number to the list, call the 
 * backtrack mthod recursively to generate next, and then removelast once done
 */

import java.util.ArrayList;
import java.util.List;

public class Subsets{
    List<List<Integer>> res = new ArrayList<>();
    int i;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        // helper(list, i, nums);
        // backtrack(list, i, nums);

        // for(i = 0; i <= nums.length; i++){
        //     forBacktrack(nums, 0, list);
        // }
        

        forBacktrackFirst(nums,0,list);

        return res;
    }

    //for backtracking first way o(n * 2^n) 
    public void forBacktrackFirst(int[] nums, int start, List<Integer> list){
        res.add(new ArrayList<>(list));
        
        for(int k = start; k < nums.length; ++k){
            //action
            list.add(nums[k]);
            //recurse
            forBacktrackFirst(nums, k+1, list); //cause we cant choose the same element more than once
            //backtrack
            list.remove(list.size()-1);
        }
    }

    // O(n * 2^n)
    public void backtrack(List<Integer> path, int i, int[] nums){
        //base 
        if(i == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        //logic 
        //no choose 
        backtrack(path, i+1, nums);

        //choose 
        path.add(nums[i]);
        backtrack(path, i+1, nums);
        path.removeLast();
    }

    //non backtracking based -recursive
    public void helper(List<Integer> path, int i, int[] nums){
        //base 
        if(i == nums.length){
            res.add(path);
            return;
        }

        //logic 
        //no choose 
        helper(new ArrayList<>(path), i+1, nums);

        //choose 
        path.add(nums[i]);
        helper(new ArrayList<>(path), i+1, nums);
    }

    //for backtracking - not covered in class 
    public void forBacktrack(int[] nums, int start, List<Integer> list){
        if(list.size() == i){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int k = start; k < nums.length; ++k){
            //action
            list.add(nums[k]);
            //recurse
            forBacktrack(nums, k+1, list); //cause we cant choose the same element more than once
            //backtrack
            list.remove(list.size()-1);
        }
    }
}