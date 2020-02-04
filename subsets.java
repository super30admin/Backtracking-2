// Time Complexity : O(n*2^n) where n is the length of the string s
// Space Complexity : O(2^n) where n is the length of the string s
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Backtracking

class subsets {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return ans;
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }
    
    private void backtrack(int[] nums, int index, List<Integer> list) {
        // base case
        if (index > nums.length) return;
        // logic
        ans.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}x