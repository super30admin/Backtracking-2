// Time Complexity: O(2^n) where n is the number of elements in the input array
// Space Complexity: O(n) where n is the number of elements in the input array

// Approach:
// 1. We will use recursion to solve this problem.
// 2. We will have a helper function which will take the input array, result list, path list and the index.
// 3. We will add the path list to the result list at the beginning.


import java.util.ArrayList;
import java.util.List;

class Subsets {


    public List<List<Integer>> subsets01Recursion(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return result;
        }

        List<Integer> path = new ArrayList<>();
        result.add(new ArrayList<>());
        helper(nums, result, path, 0);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> path, int idx){
        // base
        if(idx == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        helper(nums, result, path, idx+1);

        path.add(nums[idx]);
        helper(nums, result, path, idx+1);
        path.remove(path.size()-1);
    }

    public List<List<Integer>> subsetsForLoopRecursion(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return result;
        }

        List<Integer> path = new ArrayList<>();
        //result.add(new ArrayList<>());
        helper1(nums, result, path, 0);
        return result;
    }

    private void helper1(int[] nums, List<List<Integer>> result, List<Integer> path, int pivot){
        // base
        result.add(new ArrayList<>(path));

        // logic
        for(int i = pivot; i < nums.length; i++){
            path.add(nums[i]);
            helper(nums, result, path, i+1);
            path.remove(path.size()-1);
        }
    }
}
