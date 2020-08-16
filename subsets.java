// Time - O(2^n)
// Space - O(n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0)
            return new ArrayList<>();
        
        result= new ArrayList<>();
        
        helper(0,nums, new ArrayList<>());
        
        return result;
    }
    
    private void helper(int index, int[] nums, List<Integer> temp)
    {
        // base case
        result.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++)
        {
            /* Action */
            temp.add(nums[i]);
            /* Recurse */
            helper(i+1,nums,temp);
            /* Backtrack */
            temp.remove(temp.size()-1);
        }
    }
}