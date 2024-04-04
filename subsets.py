# Time Complexity : O(n * 2^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        
        def helper(i, path):
            if i == len(nums):
                result.append(path.copy())
                return
            
            helper(i+1, path)

            path.append(nums[i])
            helper(i+1, path)
            path.pop()
        
        helper(0, [])
        return result

#using pivot        
from typing import List
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        def helper(pivot, path):
            result.append(path.copy())
            for i in range(pivot, len(nums)):
                path.append(nums[i])
                helper(i+1, path)
                path.pop()
            
        helper(0, [])    
        return result

#using two for loops
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        result.append([])

        for i in range(len(nums)):
            size = len(result)
            for j in range(size):
                li = list(result[j])
                li.append(nums[i])
                result.append(li)
        
        return result

        