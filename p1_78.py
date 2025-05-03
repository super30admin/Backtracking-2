# 78. Subsets

# TC : O(2^n), where n is the length of the input array.
    # This is because for each element, we have two choices: include it or not include it
    # We process each element once, and for each one, we generate new subsets from existing ones
    # In total, we generate 2^n subsets (which is the size of the power set)
# SC : O(2^n), as we need to store all subsets of the array
    # The result list will contain 2^n subsets
    # Each subset could potentially be of size n in the worst case
    # So total space is O(n * 2^n), but since n is much smaller than 2^n, the dominant factor is 2^n

# Did this code successfully run on Leetcode : Yes

# Approach :
# This solution uses an iterative approach based on the mathematical idea that the power set can be built incrementally:
    # Start with just the empty set
    # For each element in the array, create new subsets by adding this element to all existing subsets
    # Add these new subsets to our collection
# For example, with input [1,2,3]:
    # Start with: [[]]
    # Process 1: Add [1] to each existing subset ([[]] → [[1]])
        # Result: [[], [1]]
    # Process 2: Add [2] to each existing subset ([[]] → [[2]], [[1]] → [[1,2]])
        # Result: [[], [1], [2], [1,2]]
    # Process 3: Add [3] to each existing subset ([[]] → [[3]], [[1]] → [[1,3]], [[2]] → [[2,3]], [[1,2]] → [[1,2,3]])
        # Result: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]


from ast import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # Initialize with empty subset which is always part of power set
        result = [[]]
        
        # For each number in the input array
        for num in nums:
            # Create new subsets by adding the current number to existing subsets
            new_subsets = [subset + [num] for subset in result]
            # Add these new subsets to our result
            result.extend(new_subsets)
            
        return result
        