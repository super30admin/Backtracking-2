// Time Complexity : O(2^n)
// Space Complexity : O(n) where n is the length of nums
// Did this code successfully run on Leetcode : YEs
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums==null||nums.length==0)
            return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }
    private void helper(int[] nums,int index,List<Integer>path){
        result.add(new ArrayList<>(path));
        for(int i =index;i<nums.length;i++){
            //action
            path.add(nums[i]);
            //recurse
            helper(nums,i+1,path);
            //remove
            path.remove(path.size()-1);
        }
    }
}
