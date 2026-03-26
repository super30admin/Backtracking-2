    /**
    Time Complexity = O(2^N)
    Explanation:
    Each element has two choices: include or exclude.
    This generates all possible subsets → total 2^N subsets.

    Space Complexity = O(N)
    Explanation:
    Recursion depth is N and path list stores at most N elements.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially created a new list for every recursive call,
    which increased space usage.
    Optimized it using backtracking (add → recurse → remove),
    which reuses the same list and improves efficiency.
    Also ensured to copy the path when adding to result to avoid mutation issues.
    */

    class Solution {



        List<List<Integer>> result;
    
        public List<List<Integer>> subsets(int[] nums) {
            this.result = new ArrayList<>();
            helper(nums, 0, new ArrayList<>());
            return result;
        }
    
        private void helper(int[] nums, int i, List<Integer> path) {
    
            if (i == nums.length) {
                result.add(new ArrayList<>(path)); // important copy
                return;
            }
    
            // Not choose
            helper(nums, i + 1, path);
    
            // Choose
            path.add(nums[i]);
            helper(nums, i + 1, path);
    
            // Backtrack
            path.remove(path.size() - 1);
        }
    }