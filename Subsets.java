class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> currentSet, int nums[], int index){
        result.add(new ArrayList<>(currentSet));
        int temp;
        for(int i = index;i<nums.length;i++){
            currentSet.add(nums[i]);
            helper(result, currentSet, nums, i+1);
            currentSet.remove(currentSet.size()-1);
        }
    }
}