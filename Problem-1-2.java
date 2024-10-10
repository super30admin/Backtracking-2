// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package Backtracking-2;

public class Problem-1-2 {
        List<List<Integer>> res;
        List<Integer> path;
    
        public List<List<Integer>> subsets(int[] nums) {
            this.res = new ArrayList<>();
            this.path = new ArrayList<>();
            // helper(nums,0, new ArrayList<>(), res);
            // helper(nums,0);
            forloophelper(nums,0);
            return res;
        }
    
        private void forloophelper(int [] nums, int pivot){
            res.add(new ArrayList<>(path));
            for(int i = pivot; i < nums.length; i ++){
                //action
                path.add(nums[i]);
                //recurse
                forloophelper(nums, i + 1);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
}
