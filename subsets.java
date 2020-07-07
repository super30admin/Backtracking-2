/**
 * Time: O(2^n) n- length of the input array nums
 * Space: O(n)
 */
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums, new ArrayList<Integer>(), 0);
        return res;
    }
    public void helper(int[] nums, List<Integer> lst, int index){
        if(index == nums.length){
            res.add(new ArrayList<Integer>(lst));
            return;
        }

        //choose
        lst.add(nums[index]);
        helper(nums,lst,index+1);
        lst.remove(lst.size()-1);

        //dont choose
        helper(nums,lst,index+1);
    }
}