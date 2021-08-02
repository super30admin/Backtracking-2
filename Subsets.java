// Time Complexity : O(N*2^N) N-> length of array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {

        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        res = new ArrayList<>();

        helper(nums, 0, new ArrayList<>());

        return res;
    }
    private void helper(int[] nums,int index, List<Integer> list) {


        res.add(new ArrayList<>(list));


        for(int i=index; i<nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i+1, list);
            list.remove(list.size()-1);
        }

    }
}