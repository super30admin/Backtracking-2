import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    // for loop recusrion
    // TC: exponential
    // SC: O(n) nums.length
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, ArrayList<Integer> path) {
        result.add(new ArrayList<>(path));
        //logic
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    //recusrion call with back tracking
    // TC : exponential
    // SC : O(n) number of elements
    class Solution {
        List<List<Integer>> result;

        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            if (nums == null || nums.length == 0) return result;

            helper(nums, 0, new ArrayList<>());
            return result;
        }

        private void helper(int[] nums, int index, ArrayList<Integer> path) {
            //base case
            if (index == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            //logic
            //not choose case. 0 case
            helper(nums, index + 1, path);
            //choose case 1 case
            path.add(nums[index]);
            helper(nums, index + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
