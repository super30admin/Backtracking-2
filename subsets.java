// Time Complexity: O(n) as all nodes will be traversed only once
// Space Complexity: Recursive stack takes a maximum of O(h)
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approach
// Idea here is to recurse through the list and perform a not choose case where we will not add number to list and in choose we will add number to list
// once we reach last element from either way we backtrack and start with previous value.
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        helper(nums,0, new ArrayList<>());
        return result;
    }
    
    public void helper(int[] nums, int index, List<Integer> numList) {
        if(index == nums.length) {
            result.add(new ArrayList(numList));
            return;
        }
        
        // not choose
        helper(nums, index+1, numList);
        // choose
        numList.add(nums[index]);
        helper(nums, index+1, numList);
        numList.remove(numList.size()-1);
    }
}