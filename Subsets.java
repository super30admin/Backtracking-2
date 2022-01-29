// Time Complexity : O(2 power n)
// Space Complexity : O(2 power n)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        // helper_01(nums, 0 , new ArrayList<>());
//        helper_for_loop(nums, 0, new ArrayList<>());

        //iterative solution
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++){
            int k = result.size();
            for (int j = 0; j < k; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }

    private void helper_01(int[] nums, int index, List<Integer> path) {

        //base
        if (index == nums.length) {
            result.add(path);
            return;
        }
        //logic

        //not choose
        helper_01(nums, index + 1, path);

        //choose
        List<Integer> temp = new ArrayList<>(path);
        temp.add(nums[index]);
        helper_01(nums, index + 1, temp);

    }

    private void helper_for_loop(int[] nums, int index, List<Integer> path) {

        //add at every node
        result.add(new ArrayList<>(path));

        //logic
        for (int i = index; i < nums.length; i++) {
            //action
            path.add(nums[i]);
            //recurse
            helper_for_loop(nums, i + 1, path);
            //backtrack
            path.remove(path.size() - 1);
        }

    }
}