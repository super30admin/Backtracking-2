//Time complexity: O(2^N)
//Space complexity: O(N)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        helperMethod(nums, 0, new ArrayList<>());
        return result;
    }
    
    public void helperMethod(int[] nums, int index, List<Integer> subsets) {
        //logic
        result.add(new ArrayList<>(subsets));
        for(int i = index; i < nums.length; i++) {
            subsets.add(nums[i]);
            helperMethod(nums,i + 1,subsets);
            subsets.remove(subsets.size() - 1);
        }
    }
}