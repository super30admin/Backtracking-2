//TC = O(2^n)
//SC = O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int idx, List<Integer> path)
    {
        //base case
        if(idx == nums.length)
        {
            result.add(new ArrayList<>(path)); 
            return;
        }

        helper(nums, idx+1, path);

        
        path.add(nums[idx]);

        helper(nums, idx+1, path);

        //backtrack
        path.remove(path.size()-1);
    }
}
