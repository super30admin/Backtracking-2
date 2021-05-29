class Solution {
    //Time O(N*2^N)
    //Space O(H)
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums , new ArrayList<>() , 0);
        return result;
    }
    public void helper(int[] nums, List<Integer> list , int index)
    {
        //base
        result.add(new ArrayList<>(list));
        //logic
        for(int i=index ; i<nums.length ; i++)
        {
            list.add(nums[i]);
            helper(nums , list , i+1);
            list.remove(list.size()-1);
        }
    }
}