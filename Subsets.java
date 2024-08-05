// Time Complexity : O(2^N)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> result = new ArrayList<>(); 
    private void helper(int[] nums, int pivot, ArrayList<Integer> path, int n){
        if(pivot == n) return;
        


        path.add(nums[pivot]);
        result.add(new ArrayList<>(path));

        helper(nums, pivot+1, path, n);
        path.remove(path.size()-1);
        helper(nums, pivot+1, path, n);

        // if(pivot+1< n){
        //     //System.out.println(pivot + 1);
        //     //System.out.println(nums[pivot + 1]);

        //     path.add(nums[pivot+1]);
        //     helper(nums, pivot+2, path, n);
        //     path.remove(path.size()-1);
        // }
        
        
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        helper(nums, 0, new ArrayList<>(), n);
        result.add(new ArrayList<>());
        return result;
    }
}
