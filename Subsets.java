// Time Complexity : O(2^(n)) where n is the length of nums array.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : I followed 0/1 recursion with backtracking and while the base condition is met, before storing the result we store a deep
// copy of it so that the rest of recursion happens without any issues. In no choose and choose condition, index needs to be increased as we dont need
// duplicates in subsets. Once we find the result or we reach the end of the recursive function, we remove the last element in the path so that it can continue recursion.


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path){
        if(index == nums.length){
            result.add(new ArrayList<>(path));//add deep copy to result
            return;
        }
        //don't choose
        helper(nums, index+1, path);

        //choose
        path.add(nums[index]);
        helper(nums, index+1, path);//recurse
        path.remove(path.size()-1); //backtrack
    }
}