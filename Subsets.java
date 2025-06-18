//Time Complexity : O(n*2^n)
//Space Complexity : O(n*2^n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums, 0, path, result);
        return result;
    }
        private void helper(int[] nums, int idx, List<Integer> path, List<List<Integer>> result){
            if(idx == nums.length){
                result.add(new ArrayList<>(path));
                return;
            }

            helper(nums, idx+1, path, result);
            path.add(nums[idx]);
            helper(nums, idx+1, path, result);
            path.remove(path.size()-1);
   
    }
}
