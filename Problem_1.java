/* 

Subsets (https://leetcode.com/problems/subsets/)

Time Complexity : O(2^n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recursive(nums, 0, new ArrayList<Integer>());
        return result;
    }

    private void recursive(int[] nums, int index, List<Integer> path){
        result.add(new ArrayList<>(path));
        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            recursive(nums, i+1, path);
            path.remove(path.size() - 1);
        }


    }
}