"""

    Student : Shahreen Shahjahan Psyche
    Time : O(N*2^N)
    Space : O(N)

    This code ran for all the test cases in Leetcodee


"""

from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        # edge case
        if not nums:
            return []
        
        # output array
        result = []
        # array that will be used to backtrack the subsets
        temp = []
        
        def helper(nums, pos, temp, result):
            
            # appending the current subset. Copying into a new array
            result.append(list(temp))
            
            # now starting from the current pos and creating the subset until wee reach the last of nums
            for i in range(pos, len(nums)):
                temp.append(nums[i])
                helper(nums, i+1, temp, result)
                temp.pop()
        
        
        helper(nums, 0, temp, result)
        
        return result