// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : some difficulty with concept but understood now


// Your code here along with comments explaining your approach

public class Subsets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int i, List<Integer> path){
        //base
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic

        //dont choose
        helper(nums, i+1, path);

        //choose
        path.add(nums[i]);
        helper(nums, i+1, path);

        //backtrack
        path.remove(path.size() - 1);


    }
}