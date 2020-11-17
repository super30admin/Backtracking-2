# Time Complexity: Exponential
# Space Complexity: Exponential
# Approach: Solved using backtracking. In the rucursive function, pick every number and append it to the slate. 
# Use index to keep track of the remaining subproblem. 
# Call the recursive problem exhaustively till index equals length of the array.
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        out = []
        
        def helper(index, slate):
            out.append(slate[:])
            
            if index == len(nums):
                return
            
            for i in range(index, len(nums)):
                slate.append(nums[i])
                helper(i+1, slate)
                slate.pop()
                
        helper(0, [])
        return out