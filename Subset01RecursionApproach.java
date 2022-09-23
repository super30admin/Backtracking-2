// Time complexity: exponential. O(2^N)
// Space complexity: O(N) for storing the path

// Approach: We use the 0-1 based recursion backtracking approach.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null) return result;
        backTrackHelper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void backTrackHelper(int[] nums, int idx, List<Integer> path) {
        // base
        if (idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        // logic
        // not choose
        backTrackHelper(nums, idx + 1, path);
        
        // choose
        // action
        path.add(nums[idx]);
        // recurse
        backTrackHelper(nums, idx + 1, path);
        // backtrack
        path.remove(path.size() - 1);
    }
}