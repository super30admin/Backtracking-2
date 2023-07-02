// Time Complexity : O(2^n)
// Space Complexity : O(n) n is the height of the tree
import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        // helper(nums, new ArrayList<>(), 0);
        forLoop(nums, new ArrayList<>(), 0);
        return result;
    }

    private void helper(int[] nums, List<Integer> subset, int idx) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // don't choose
        helper(nums, subset, idx + 1);
        subset.add(nums[idx]);
        // choose
        helper(nums, subset, idx + 1);
        subset.remove(subset.size() - 1);
    }

    private void forLoop(int[] nums, List<Integer> subset, int pivot){
        result.add(new ArrayList<>(subset));
        for(int i=pivot;i<nums.length;i++){
            subset.add(nums[i]);
            forLoop(nums,subset,i+1);
            subset.remove(nums[i]);
        }
    }
}