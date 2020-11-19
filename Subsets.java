/**
 * TC : 2^n SC : O(N)
 * Approach : We can obtain different combination of the elements by choosing one and not choosing. so at every step we can decide either,
 *            add that to current lsit or not and if we run out of elements to choose from that list can be added to the result.
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        helper(nums,new ArrayList<>(), res, 0);
        return res;
    }
    
    private void  helper(int[] nums, List<Integer> temp, List<List<Integer>> res, int index){
        //Base
        if(index > nums.length) return;
        if(index == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        //Logic
        //choose
        //List<Integer> temp2 = new ArrayList<>(temp);
        //Action
        temp.add(nums[index]);
        //Recurse
        helper(nums,temp,res,index+1);
        //Backtrack
        temp.remove(temp.size()-1);
        //don't choose
        helper(nums,temp,res,index+1);
    }
}