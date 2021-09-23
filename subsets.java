// Time Complexity : O(2^n)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Recursion:
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helper(nums, 0,  new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path){
        // base
        if(index == nums.length){
            result.add(path);
            return;
        }
        // logic
            // no choose
        helper(nums, index+1, new ArrayList<>(path));
            //choose
        path.add(nums[index]);
        helper(nums, index+1,  new ArrayList<>(path));
    }
}
// ****************************************

// Backtracking:
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helper(nums, 0,  new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path){
        // base
        if(index == nums.length){
            result.add( new ArrayList<>(path));
            return;
        }
        // logic
            // no choose
        helper(nums, index+1,path);
            //choose
        path.add(nums[index]);
        helper(nums, index+1, path);
        // backtrack
        path.remove(path.size() - 1);
    }
}
// ****************************************

// for loop recursion:
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path){
        // base
        // logic
        result.add(new ArrayList<>(path));
        for(int i=index; i <nums.length; i++){
            // action
            // path.add(nums[i]);
            List<Integer> newList = new ArrayList<>(path);
            newList.add(nums[i]);
            // recursion
            // helper(nums, i+1, path);
            helper(nums, i+1, newList);
            // backtrack
            // path.remove(path.size()-1);
        }
    }
}