// Time Complexity - O(2^n);
// Space complexity - O(n)
// Solved on leetcode - yes
// Did you face any issues - NO
// The algorithm uses backtracking to generate all possible subsets of the input array. At each step, it includes or excludes the current element, recursively exploring further possibilities starting from the next index. Every intermediate path (including the empty one) is added to the result, eventually covering all 2^n subsets.
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] nums, int idx, List<Integer> path) {
        //base
        result.add(new ArrayList<>(path));
        //logic
        for(int i = idx;i<nums.length;i++) {
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}
