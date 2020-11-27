/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

// T: O(2 ^ n) where n is no of elements

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
         Arrays.sort(nums);
        subset(result, nums, new ArrayList<Integer>(), 0);
        
        return result;
    }
    
    public void subset(List<List<Integer>> result, int[] nums, List<Integer> temp, int start){
        
        result.add(new ArrayList<Integer>(temp));
        
        for(int i = start; i < nums.length; i++){
            
            temp.add(nums[i]);
            subset(result, nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}