//classic recursive prorblem

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path) {
        //base
        if(index == nums.length) {
            result.add(path);
            return;
        }
        //logic
        //do not choose
        helper(nums, index + 1, new ArrayList<>(path));
        //choose
        path.add(nums[index]);
        helper(nums, index + 1, new ArrayList<>(path));
    }
}