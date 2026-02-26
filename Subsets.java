/*

Approach: for every element, duplicate all the existing subsets, 
and append the current element to each duplicate.
we have to build the power set of all subsets layer by layer.
solution without recursion.

 */

/*
  -- Time: O(n × 2^n), n = number of elements in the input array,
  copying a subset can take up to O(n) time in the worst case.
  -- Space: O(n × 2^n).
 */

// Yes the code successfully ran over leetcode


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        // This will store all subsets (power set)
        List<List<Integer>> result = new ArrayList<>();
        
        // Start with empty subset (base of power set)
        result.add(new ArrayList<>());
        
        
        for(int i = 0; i < nums.length; i++){
            
            // creating snapshot
            int size = result.size();
            
            // For every existing subset
            for(int j = 0; j < size; j++) {
                
                // Copy existing subset
                List<Integer> temp = new ArrayList<>(result.get(j));
                
                // Add current element to it
                temp.add(nums[i]);
                
                // Add new subset into result
                result.add(temp);
            }
        }
        
        
        return result;
    }
}