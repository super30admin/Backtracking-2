class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0);
        return result;
    }
    private void helper(int[] nums, List<Integer> temp, int index){
        // base
        if(index == nums.length){
            result.add(temp);
            return;
        }
        
        // logic
        
        // don't choose
        helper(nums, new ArrayList<>(temp), index + 1);
        // choose
        temp.add(nums[index]);
        helper(nums, new ArrayList<>(temp), index + 1);
        
        
        
    }
}
