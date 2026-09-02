//Time Complexity: O(n * 2 power n)
//Space complexity: O(n power 2)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path)
    {
        result.add(new ArrayList<>(path));

        for(int i = index; i < nums.length; i++){

            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i+1, path);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}