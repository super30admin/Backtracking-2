// back track for loop soln.
// Time Complexity : O(2powerN)
// Space Complexity : O(N) for path if we neglect result space.
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0)
            return result;
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }
    private void backtrack(int[] nums, List<Integer> path, int index){
        result.add(new ArrayList<>(path));
        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, path, i+1);
            path.remove(path.size() - 1);
        }
    }
}

/*
// back track 1-0 soln.
// Time Complexity : O(2powerN) 
// Space Complexity : O(N) for path if we neglect result space.
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0)
            return result;
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }
    private void backtrack(int[] nums, List<Integer> path, int i){
        //base
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //choose
        path.add(nums[i]);
        backtrack(nums, path, i+1);
        path.remove(path.size() - 1);
        //dont choose
        backtrack(nums, path, i+1);
    }
}
*/