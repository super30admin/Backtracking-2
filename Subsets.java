// Time Complexity : O(2^n)
// Space Complexity : O(N) - stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Recursion - T - O(n * 2^n), S= O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int i, List<Integer> path) {
        // base case
        if(i == nums.length){
            result.add(path);
            return;
        }

        //logic
        //dont choose
        helper(nums, i+1, new ArrayList<>(path));

        //choose
        path.add(nums[i]);
        helper(nums, i+1, new ArrayList<>(path));
    }
}

// BackTracking - T - O( 2^n), S= O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int i, List<Integer> path) {
        // base case
        if(i == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        //action
        path.add(nums[i]);
        //recursive call for choose
        helper(nums, i+1, path);
        //backtrack
        path.remove(path.size()-1);
        //not choose
        helper(nums, i+1, path);

    }
}

// BackTracking Iterative Approach - T - O( 2^n), S= O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path) {

        result.add(new ArrayList<>(path));

        for(int i=pivot;i< nums.length;i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }

    }
}

// Without recurssion
// T =O(n * 2^n)
// s = O(1)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();

        result.add(new ArrayList<>());

        for(int i=0;i<nums.length;i++) {
            int n = result.size();
            for(int j=0;j< n;j++) {
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                result.add(li);

            }
        }
        return result;
    }
}