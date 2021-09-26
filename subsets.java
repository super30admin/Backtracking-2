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
        //base
        if(index == nums.length) {
            result.add(new ArrayList<>(subsets));
            return;
        }
        //not choose
        helperMethod(nums, index + 1, subsets);
        
        //choose
        subsets.add(nums[index]);
        helperMethod(nums, index + 1, subsets);
        //backtrack
        subsets.remove(subsets.size() - 1);
    }
}