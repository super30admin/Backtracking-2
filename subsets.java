class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        helper(nums,0,y);
        return res;
    }
    public void helper(int[] nums,int pivot,List<Integer>path)
    {
        res.add(path);


        for(int i=pivot;i<nums.length;i++)
        {
            List<Integer>l = new ArrayList<>(path);
            l.add(nums[i]);
            helper(nums,i+1,l);
        }
    }
}