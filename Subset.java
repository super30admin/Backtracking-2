/*
// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
 */
class Solution {
    List<Integer> temp;

    private void doComb(int[] nums, List<List<Integer>> ret, int indx){
        //add temp at each level
        ret.add(new ArrayList<>(temp));
        
        //base case
        if(indx >= nums.length)
            return;

        //logic
        for(int i = indx; i <nums.length; i++){
            temp.add(nums[i]);
            doComb(nums, ret, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        this.temp = new ArrayList<>();

        doComb(nums, ret, 0);
        return ret;
    }
}
