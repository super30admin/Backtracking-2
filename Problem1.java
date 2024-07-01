/*
    LC - 78. Subsets
    TC - O(2 ^ n)
    SC - O(n) + O(n) ~ O(n)
        While the result list will ultimately contain 2^n subsets, we don't count this as part of the auxiliary space complexity. It's considered part of the output space.
        Therefore, the overall space complexity is O(n).
    Approach - using pick / no pick approach. and for loop based backtrack.
*/

class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtrack(nums, 0);
        return result;
    }  
    public void backtrack(int[] nums, int index) {
        // base
        result.add(new ArrayList<>(path));

        // logic
        for(int i=index; i<nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i+1);
            path.remove(path.size() - 1);
        }
    }
}