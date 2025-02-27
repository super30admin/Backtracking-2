//The approach here is to use 0/1 recursion to be exhaustive and add all possible subsets to the result list.
//We use a path list add numbers to it based on 2 conditions, if we choose the element or not.
// We add the copy of the path list to the result when we reach the end of the list.
//We also use backtracking to remove the last added element from the path before going to the parent after recrusing children for efficiency.
//Time Complexity: O(2^n), where n is the length of the given array
//Space Complexity: O(n), for recursive stack space
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums, 0, path, result);
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path, List<List<Integer>> result){
        //base
        if(idx == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        helper(nums, idx+1, path, result);
        //action
        path.add(nums[idx]);
        //recurse
        helper(nums, idx+1, path, result);
        //backtrack
        path.remove(path.size()-1);
    }
}

//We use the same approach as above here, but we use for-loop based recursion
//Time Complexity: O(2^n), where n is the length of the given array
//Space Complexity: O(n), for recursive stack space
class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums, 0, path, result);
        return result;
    }
    private void helper(int[] nums, int pivot, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<>(path));
        for(int i = pivot; i<nums.length; i++){
            path.add(nums[i]);            
            helper(nums, i+1, path, result);
            path.remove(path.size()-1);
        }
    }
}


//In this approach, we iterate through the array and add elements to the result.
//When iterating, we duplicate the current result list and we add the current element to all of the list members
//Time Complexity: O(2^n), where n is the length of the given array
//Space Complexity: O(1)
class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0; i<nums.length; i++){
            int size = result.size();
            for(int j = 0; j<size; j++){
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                result.add(li);
            }            
        }
        return result;
    }
}