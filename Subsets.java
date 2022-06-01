// Time Complexity: O(2^n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

import java.awt.*;
import java.util.ArrayList;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
        return subsets;

    }

    public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        //logic
        for(int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            // recurse
            generateSubsets(i + 1, nums, current, subsets);
            // backtrack
            current.remove(current.size() - 1);
        }
    }
}
