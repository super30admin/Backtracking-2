class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    
    void helper(int[] nums, int index, List<Integer> subset) {
        res.add(new ArrayList<>(subset));
        for(int i=index; i<nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, i+1, subset);
            subset.remove(subset.size()-1);
        }
        return;
    }
}
