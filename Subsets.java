// Time Complexity : O( n * 2^n)
// Space Complexity : O(n * 2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, ArrayList<Integer> temp, int start){
        result.add(new ArrayList<>(temp));

        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(result, nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
