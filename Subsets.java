// Time Complexity : O(2^N)
// Space Complexity : O(2^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Subsets {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
       helper(nums, 0, new ArrayList());
       return result; 
    }
    private void helper(int[] nums, int idx, List<Integer> path){
        //base
        if(idx == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        //dont choose
        helper(nums,idx+1,path);

        //choose
        //action
        path.add(nums[idx]);
        helper(nums,idx+1,path);

        //backtrack
        path.remove(path.size()-1);
    }
} 