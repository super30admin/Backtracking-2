// Time Complexity : O(n*2^n) (each element can be choosen or not, and for each result we copy all the path to result)
// Space Complexity : O(n) (path can be at max n length, and result can have 2^n subsets)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// In 01 recursion, we choose to include each element in the path and bactrack and not include it and check all the substrings at the leaf nodes
// In for loop recursion, we iterate over all the elements from the pivot and include each element in the path and recurse for the next elements
// In nested loops, we iterate each element and add it to the existing substrings in the result by making a fresh copy each time. We start with an empty subset in the result.

class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        result.add(new ArrayList());
        for(int i=0;i<nums.length;i++){
            int le = result.size();
            for(int j=0;j<le;j++){
                List<Integer> li = new ArrayList(result.get(j));
                li.add(nums[i]);
                result.add(li);
            }
        }
        return result;
    }

    private void helper_01Recursion(int[] nums, int i, List<Integer> path){
        if(i==nums.length){
            result.add(new ArrayList(path));
            return;
        }
        //dont choose
        helper(nums,i+1,path);
        //chose
        path.add(nums[i]);
        helper(nums,i+1,path);
        path.remove(path.size()-1);
    }

    private void helper_ForLoopRecursion(int[] nums, int pivot, List<Integer> path){
        result.add(new ArrayList(path));
        for(int i=pivot;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}