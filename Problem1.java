// https://leetcode.com/problems/subsets/
// Time complexity : O(2^N)
// Space complexity : O(N)

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,0,res,new ArrayList<>());
        return res;
    }
    public void helper(int []nums,int index,List<List<Integer>> res,List<Integer> l){
        if(index > nums.length)
            return;
        
        res.add(new ArrayList<>(l));
        for(int i=index;i<nums.length;i++){
            l.add(nums[i]);
            helper(nums,i+1,res,l);
            l.remove(l.size()-1);
        } 
    }
}