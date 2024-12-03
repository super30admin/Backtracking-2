class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result=new ArrayList<>();
        helper(0,nums,new ArrayList<>());
        return result;
    }
    public void helper(int i,int[] nums,List<Integer> subset)
    {
        if(i>=nums.length)
        {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        helper(i+1,nums,subset);
        subset.remove(subset.size()-1);
        helper(i+1,nums,subset);

    }
}