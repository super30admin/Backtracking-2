// Time Complexity : O(n*(2^n)) n is the total elements
// Space Complexity : O(n) n is the total nos.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path){
        //base


        //logic
        result.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++){
            //List<Integer> temp = new ArrayList<>(path);
            path.add(nums[i]);
            //recurse
            helper(nums,i+1,path);
            //backtrack
            path.remove(path.size()-1);
        }
    }

    public static void main(String [] args){
        Subsets s = new Subsets();
        System.out.println(s.subsets(new int[]{1,2,3}));
    }
}