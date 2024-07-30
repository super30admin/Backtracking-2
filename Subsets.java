// Time Complexity: O(2^n * n), n: no.of elements in the array
// Space Complexity: O(2^n * n), store all subsets, n for recursive stack

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        findSubsets(nums, index, result, new ArrayList<>());
        return result;
    }

    private void findSubsets(int[] nums, int index, List<List<Integer>> result, List<Integer> subset) {
        result.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            findSubsets(nums, i + 1, result, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
