package Backtracking2;
// Time Complexity :O(2^n)
// Space Complexity : O(h) (recursion stack)
// Did this code successfully run on Leetcode : yes

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, int index, List<Integer> path){
        //base
        if(nums.length == index) {
            return;
        }
        //logic
        for(int i=index; i<nums.length; i++){
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            backtrack(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}
