// Time complexity: exponential. O(2^N)
// Space complexity: O(N) for storing the path

// Approach: We use the forloop based recursion backtracking approach. At every recursion call we get a sequence so be just add it to the list

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null) return result;
        backTrackHelper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void backTrackHelper(int[] nums, int pivot, List<Integer> path) {
        // base
        result.add(new ArrayList<>(path));
        
        // logic
        for (int i = pivot; i < nums.length; i++) {
            // action
            path.add(nums[i]);
            backTrackHelper(nums, i+1, path);
            path.remove(path.size() - 1);
        }
    }
}