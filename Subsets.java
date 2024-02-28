// Time complexity: O(2 ^ n)
// Space complexity: O(n) Recursive stack

// Approach: For loop recursion and add each path to res

import java.util.ArrayList;
import java.util.List;

class Subsets {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList();
        // empty array list
        res.add(new ArrayList());
        dfs(0, nums, new ArrayList());
        return res;
    }

    private void dfs(int index, int[] nums, List<Integer> path) {
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList(path));
            dfs(i + 1, nums, path);
            path.remove(path.size() - 1);
        }
    }
}