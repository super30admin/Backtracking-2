// Approach: Brute force, we do a deep copy at each recursion step and use a new list

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
        result.add(path);
        
        // logic
        for (int i = pivot; i < nums.length; i++) {
            // action
            List<Integer> temp = new ArrayList<>(path);
            temp.add(nums[i]);
            backTrackHelper(nums, i+1, temp);
        }
    }
}