# Approach: 
# The problem can be solved using backtracking. We start with an empty subset, 
# and for each element in the input array, we either include it in the current 
# subset or exclude it. We repeat this process for all elements to generate 
# all possible subsets.

# Time Complexity: O(2^n), where n is the length of the input list. This is because 
# there are 2^n possible subsets of a set of size n.
# Space Complexity: O(n), where n is the length of the input list. We store subsets 
# in a list, and each recursive call can add up to n elements in the worst case.

# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No, the approach is simple and follows
# standard backtracking principles.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # List to store all subsets
        result = []
        
        # Helper function for backtracking
        def backtrack(start, path):
            # Append the current subset (path) to the result
            result.append(path[:])  # path[:] is a copy of the current subset
            
            # Iterate through the remaining elements
            for i in range(start, len(nums)):
                # Include nums[i] in the subset and move to the next element
                path.append(nums[i])
                # Recurse with the new subset
                backtrack(i + 1, path)
                # Backtrack: remove the last element to explore other subsets
                path.pop()
        
        # Call the backtracking function starting with an empty subset
        backtrack(0, [])
        
        return result
