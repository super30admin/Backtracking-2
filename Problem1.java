import java.util.ArrayList;
import java.util.List;

// Time Complexity :O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0,new ArrayList<>());
        return output;
    }
    private void backtracking(int[] nums, int start, List<Integer> path)
    {
        output.add(new ArrayList<>(path));
        for(int i = start;i<nums.length;i++)
        {
            path.add(nums[i]);
            backtracking(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}