## Problem1 
# Subsets (https://leetcode.com/problems/subsets/)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        """
        Time Complexity: O(N * 2^N)
        - There are 2^N possible subsets for an array of size N.
        - In the base case, creating a shallow copy of the path (using list(path)) takes O(N) time.
        
        Space Complexity: O(N)
        - The maximum depth of the recursion tree is N.
        - The auxiliary `path` array stores at most N elements.
        - Note: This does not include the O(N * 2^N) space required to hold the final result array.
        """
        result = []
        
        def helper(idx, path):
            nonlocal result, nums
            
            # Base case: We have made a choose/don't choose decision for every element.
            # We reached the end of the array, so the current path is a valid subset.
            if idx == len(nums):
                result.append(list(path)) # Create a shallow copy to prevent reference mutation
                return 
            
            # --- Recursive Logic (Backtracking) ---
            
            # Option 1: Not Choose Case
            # We skip the current element at 'idx' and move to the next element.
            # The path remains unmodified.
            helper(idx + 1, path)
            
            # Option 2: Choose Case
            # We include the current element at 'idx' in our subset path.
            path.append(nums[idx])
            
            # Explore all further possibilities with this element included.
            helper(idx + 1, path)
            
            # Backtrack: Remove the element we just added before returning to the previous 
            # level of the recursion tree, so it doesn't leak into other parallel branches.
            path.pop()
            
        # Start the recursion at index 0 with an empty current subset.
        helper(0, [])
        
        return result