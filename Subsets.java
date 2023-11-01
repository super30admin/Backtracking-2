// Time Complexity : O(n2^n)
// Space Complexity : O(n2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int idx, List<Integer> path){

        //base
        result.add(new ArrayList<>(path));
        //logic
        for(int i = idx; i < nums.length; i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }


        // //base
        // if(idx == nums.length){
        //     result.add(new ArrayList<>(path));
        //     return;
        // }

        // //logic
        // //no choose
        // helper(nums, idx+1, path);

        // //choose
        // //action
        // path.add(nums[idx]);

        // //recurse
        // helper(nums, idx+1, path);

        // //backtrack
        // path.remove(path.size()-1);

    }
}
