class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        helper(nums,0,new ArrayList<>());
        return res;

    }

    private void helper(int[] nums , int index , List<Integer> temp)
    {
        if(index == nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);

        helper(nums,index+1,temp);

        temp.remove(temp.size()-1);

        helper(nums,index+1,temp);
    }
}
