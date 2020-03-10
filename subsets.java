// Time Complexity : O(2^n); n : number of elements in nums array
// Space Complexity : O(n) : the temp list will contain atmost n elements. The same list is being reused in this case.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach 1: Backtracking
// 1. In this approach, first the choice is made to go with a particular element and the element is added to the temporary list.
// 2. Once the end of list/array is reached, backtracking is done. In this step the choice of not selecting a particular element is explored.
// 3. The same datastructure is used while recursing wherein the last element is removed from the data structure.

// In this scenario, complete exploration is done by selecting all elements. Subsets are formed by adding elements to the chosen data structure.
// While backtracking, last element is removed and other subset paths are explored.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // result list
        List<List<Integer>> result = new ArrayList<>();
        // edge case
        if(nums == null || nums.length == 0) return result;
        // backtrack
        // adding empty subset
        result.add(new ArrayList<>());
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, int index) {
        for(int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, result, temp, i+1);
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
        }
    }
}


// Time Complexity : O(2^n); n : number of elements in nums array
// Space Complexity : O(n*2^n) : the temp list will contain atmost n elements. At every step a new list is created.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach 2: Recursion
// We have 2 choices to make at every step: either to choose the element and not to choose the element.
// For each choice recursive paths will be explored and output will be added in a new list.
/*
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // result list
        List<List<Integer>> result = new ArrayList<>();
        // edge case
        if(nums == null || nums.length == 0) return result;
        recurse(nums, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void recurse(int[] nums, List<List<Integer>> result, List<Integer> temp, int index) {
        // base case
        if(index >= nums.length) {
            result.add(temp);
            return;
        }
        // case 1: do not choose an element
        recurse(nums, result, new ArrayList<>(temp), index+1);
        
        // case 2: choose an element
        temp.add(nums[index]);
        recurse(nums, result, new ArrayList<>(temp), index+1);
        
    }
}
*/
