// Time Complexity : O(2^N), N = elements in nums
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Subsets {
    private List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int i, List<Integer> path) {
        //base
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //no choose
        helper(nums, i+1, path);
        //choose
        path.add(nums[i]);
        helper(nums, i+1, path);
        path.remove(path.size()-1); //backtracking
    }
}
