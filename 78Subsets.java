// Time Complexity : n* 2^(n), n = length of array, exploring all the options.O(n) time extra for making a deep copy at every level.
// Space Complexity :O(1), because auxillary space is being used in output n for keeping track of path which will get added to result  
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Explore all the paths using for loop based recursion and use backtracking to avoid creating deep copy of path at each level.

class Solution {
   List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(0,nums,  new ArrayList<>());
        return result;
    }

    private void helper(int pivot, int[] nums, List<Integer> path){
        result.add(new ArrayList<>(path));

        for(int i = pivot ; i < nums.length ; i++){
            path.add(nums[i]);
            helper(i+1, nums, path);
            path.remove(path.size()-1);
        }
    }
}


// Zero one recursion 
//TC = n * 2^n, O(n) time extra for making a deep copy at every level.
// SC = n * 2^n, O(n) space for making a deep copy at every level. height of the tree will be recursive stack space.

class Solution {
    int i;
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        helper(0,nums,  new ArrayList<>());
        return result;
    }

    private void helper(int i, int[] nums, List<Integer> path){
        if(i == nums.length) return;
        // dont choose
        helper(i+1, nums, path);

        path.add(nums[i]);

        result.add(new ArrayList<>(path));
        //choose
        helper(i+1, nums, path);
        path.remove(path.size()-1);

    }
}
