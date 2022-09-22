// Time Complexity : O(2^N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no




class Problem1 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        helper(nums, 0, new ArrayList<>());

        return result;



    }

    /***
     * Can be done using backtracking as well, we will not create a new path everytime
     */
    private void helper(int[] nums, int i, List<Integer> path){

        //base case
        if(i == nums.length){
            result.add(path);
            return;
        }

        //logic
        //not choose case
        helper(nums, i+1, new ArrayList<>(path));

        //choose case
        path.add(nums[i]);
        helper(nums, i+1, new ArrayList<>(path));
    }
}