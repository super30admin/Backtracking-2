// Time Complexity : 2^N
// Space Complexity : 2^N
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no 
// Your code here along with comments explaining your approach: backtracking logic

public class Subsets {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, int index, List<Integer> path){
        // base
        if(index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
            
        // logic
        // 0 case
        helper(nums, index+1, path);
        //1 case
        path.add(nums[index]);
        helper(nums, index+1, path);
        // remove
        path.remove(path.size()-1);
    }
}
