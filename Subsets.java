package Backtracking2;
// Time Complexity :O(2^n)
// Space Complexity : O(h) (recursion stack)
// Did this code successfully run on Leetcode : yes


import java.util.ArrayList;
import java.util.List;

//choose not choose approach
public class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        // result.add(new ArrayList<>());
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, int index, List<Integer> path){
        //base
        if(nums.length == index) {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //choose
        path.add(nums[index]);
        backtrack(nums, index + 1, path);
        path.remove(path.size()-1);

        //not choose
        backtrack(nums, index + 1, path);
    }
}
