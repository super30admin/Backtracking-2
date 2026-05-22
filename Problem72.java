// Time Complexity : O(n × 2ⁿ) - 2ⁿ
// Space Complexity : O(n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums, 0, path);
        return result;
    }

    private void helper(int[] nums, int i, List<Integer> path) {

        if (i == nums.length) {
            result.add(new ArrayList<>(path)); 
            return;
        }

        helper(nums, i + 1, path);

        path.add(nums[i]);              
        helper(nums, i + 1, path);      
        path.remove(path.size() - 1);
    }
}