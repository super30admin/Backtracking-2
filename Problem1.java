// https://leetcode.com/problems/subsets/
// Time Complexity : O(2^n) where n is the number of elements in the input array. 
//                   This is because for each element, we have two choices: 
//                   either include it in the subset or exclude it. 
//                   Therefore, the total number of subsets is 2^n.
// Space Complexity : O(2^n) for storing all the subsets.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
         helper(nums, 0, new ArrayList<>(), result);
         return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<>(path));

        for( int i = pivot; i < nums.length; i++){
            path.add(nums[i]);
            helper(nums, i+1, path, result);
            path.remove(path.size()-1);
        }
    }
}