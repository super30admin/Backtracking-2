/*
This example uses for loop based recursion to solve the problem. At each step, we add the currently computed path, 
and then recurse over the set for the next permutation till we reach all the possible subsets.

Did this code run on leetcode: Yes

*/
class Solution {
    List<List<Integer>> result;
    //Time Complexity: O(2^n)
    //Space Complexity: O(n)
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        
        helper(nums, 0, new ArrayList<>());
        
        return result;
        
    }
    
    private void helper(int[] nums, int index, List<Integer> path)
    {
        //Adding the currently generated path to the result
        result.add(new ArrayList<>(path));
        for(int i = index; i < nums.length; i++)
        {   
            path.add(nums[i]);
            
            helper(nums, i + 1, path);
            
            path.remove(path.size() - 1);
        }
    }
}