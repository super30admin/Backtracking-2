// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Method used : Backtracking

class Solution {

    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        
        helper(nums, 0, new ArrayList());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> temp)
    {
        if(index == nums.length)
        {
            result.add(new ArrayList(temp));
            return;
        }

        temp.add(nums[index]);
        helper(nums, index + 1, temp);

        temp.remove(temp.size() - 1);
        helper(nums, index + 1, temp);
    }
}