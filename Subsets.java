/*
 * TC: O(n*2^n) n: nums.length
 * SC: O(n) worst case the size of recursive stack would be nums.length
 * 
 * Approach: Implemented suing 0-1 recursion with backtracking. at each recursive call i will have 2 choice either to choose the current number or not.
 * base case would be if my index becomes nums.length then i will add the temp li to my result.
 */

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] nums, int idx, List<Integer> li){

        //base
        if(idx == nums.length){
            result.add(new ArrayList<>(li));
            return;

        }

     //choose
        li.add(nums[idx]);
        helper(nums, idx+1, li);
        //backtrack
        li.remove(li.size() - 1);

        //not choose
        helper(nums, idx+1, li);

   
    }
}