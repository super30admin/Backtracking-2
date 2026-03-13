// Time Complexity: O(n * 2^n)
// Space Complexity: O(n)
// Ran on Leetcode succefully: yes
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        helperSubsets(nums, 0, new ArrayList<>());
        return ans;
    }

    public void helperSubsets(int [] nums, int pivot, List<Integer> list) {
        // add deep copy to ans
        ans.add(new ArrayList(list));
        for(int i = pivot; i < nums.length; i++) {
            list.add(nums[i]);
            // explore subsets
            helperSubsets(nums, i + 1, list);
            // backtrack
            list.remove(list.size() - 1);
        }
    }
}