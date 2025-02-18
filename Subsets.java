//TC: O((2^n)*n), 2^n subsets, n to copy each subset to result
//SC: O(n) recursive stack
//approach: backtracking

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> currentList, List<List<Integer>> result) {
        result.add(new ArrayList<>(currentList));

        for (int i = start; i < nums.length; i++) {
            currentList.add(nums[i]);
            backtrack(nums, i + 1, currentList, result);
            currentList.remove(currentList.size() - 1);
        }
    }
}
