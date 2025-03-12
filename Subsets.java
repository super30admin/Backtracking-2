//Time Complexity : O(2^n)
//Space Complexity : O(n)
import java.util.*;
class Subsets {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, int i, List<Integer> path) {
        //base case
        if(i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        //logic
        path.add(nums[i]);
        helper(nums, i+1, path);
        path.remove(path.size() - 1);

        helper(nums,i+1,path);
    }
}