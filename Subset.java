// Time Complexity : 2 ^ n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.ArrayList;
import java.util.List;
public class Subset {

    private List<List<Integer>> result;
    private int len;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        List<Integer> path = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        len = nums.length;
        result.add(new ArrayList<>(path));
        helper(path, nums, 0);
        return result;
    }
    private void helper(List<Integer> path, int[] nums, int idx){
        if(idx == len) return;
        path.add(nums[idx]);
        result.add(new ArrayList<>(path));
        helper(path, nums, idx + 1);
        path.remove(path.size()-1);
        helper(path, nums, idx + 1);
    }
}