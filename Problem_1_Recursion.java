// Time complexity - O(2^n)
// Space complexity - O(n*2^n)

// Recursive solution

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helper(nums,new ArrayList<>(), 0);
        return result;
    }
    private void helper(int[] nums, List<Integer> tmp, int index){
        // base
        if(index == nums.length){
            result.add(tmp);
            return;
        }
        
        // logic
        helper(nums,new ArrayList<>(tmp), index+1);
        tmp.add(nums[index]);
        helper(nums,new ArrayList<>(tmp),index+1);
    }
}
