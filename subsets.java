//----------EXHAUSTIVE APPROACH--------------------
// Time Complexity :exponential
// Space Complexity :if we exclude stack space ie.height of tree==no of elements space is constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        // base case
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        helper(nums, index + 1, path);
        path.add(nums[index]);
        helper(nums, index + 1, path);
        path.remove(path.size() - 1);
    }
}
// ----------------FOR LOOP RECURSION-----------------
// Time Complexity :exponential
// Space Complexity :if we exclude stack space ie.height of tree==no of elements
// space is constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// here we are looping through all indices recursively and keeping track of path
// and adding path at each
// method call
class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        // base case
        result.add(new ArrayList<>(path));
        if (index == nums.length)
            return;

        // logic
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i + 1, path);
            path.remove(path.size() - 1);
        }

    }
}

// --------------WITHOUT RECURSION--------------------
// Time Complexity :exponential
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// we are taking list from result and adding current element in that every time
// we are at a new index
// in given input
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result;
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int n = result.size();
            for (int j = 0; j < n; j++) {
                List<Integer> temp = new ArrayList(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }

        return result;
    }

}