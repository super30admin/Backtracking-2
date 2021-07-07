
/*
O(2^N) time (generating all subsets), O(2^N) space 

Algorithm:
=========
1. Generate all possible subsets by adding a value, recursively generating subsets of its own
2. Add all of them because all possible subsets need to be generated.
3. No duplicates, so always increment index 
*/
// ================================ Backtracking =================================
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return result;
        backtrack(nums, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> temp, int index) {
        //base
        // imperative that base case is covered here because of for loop, otherwise basecase is a must
        //logic
        result.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++) {
            temp.add(nums[i]);  // add current element to temporary list
            backtrack(nums, temp, i+1); // i+1 because no duplicates
            temp.remove(temp.size()-1); //backtrack by removing element from list for reuse
        }
    }
}
// ================================ Recursion =================================
/*
Recursive approach is similar to backtracking except for using new list everytime. We have 2 options at every point: choose or not choose
*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return result;
        helper(nums, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void helper(int[] nums, List<Integer> temp, int index) {
        //base
        if(index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        //logic
        //didn't choose nums[index]
        helper(nums, new ArrayList<>(temp), index+1);
        //choose nums[index]
        temp.add(nums[index]);
        helper(nums,new ArrayList<>(temp), index+1);
        
    }
}