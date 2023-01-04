import java.util.*;

public class Subsets {

    // Approach: backtrack with choose and don't choose
    // Time: O(N*2^N)
    // Space: O(N)
    List<List<Integer>> paths = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {

        helper(nums, 0, new ArrayList());
        return paths;
    }

    void helper(int[] nums, int i, List<Integer> path) {

        if (i == nums.length) {
            paths.add(new ArrayList(path));
            return;
        }
        // don't choose
        helper(nums, i+1, path);
        // action choose
        path.add(nums[i]);
        // recurse
        helper(nums, i+1, path);
        // backtrack
        path.remove(path.size() - 1);
    }
}