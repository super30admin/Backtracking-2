Time complexity-2^n
Space Complexity-O(n)-temp array

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0) return result;
        helper(nums,new ArrayList<>(),0);
        return result;
    }
    private void helper(int[] nums, List<Integer> temp,int start)
    {
        result.add(new ArrayList<>(temp));
        
        for(int i=start;i<nums.length;i++)
        {
            temp.add(nums[i]);
            helper(nums,temp,i+1);
            temp.remove(temp.size()-1);
            
        }
    }
}
