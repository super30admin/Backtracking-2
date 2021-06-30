'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 78. Subsets

# Given an integer array nums of unique elements,
#  return all possible subsets (the power set).

# The solution set must not contain duplicate subsets.
#  Return the solution in any order.

#-----------------
# Time Complexity: 
#-----------------
# O(2^N) - Explore N binary decision tree

#------------------
# Space Complexity: 
#------------------
# O(N): Max size of intermediate path

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        if len(nums) == 0:
            return self.result
        self.helper(nums,  0, [])
        return self.result
    def helper(self, nums, index, path):
        # base
        if index == len(nums):
            self.result.append(path)
            return
        
        # logic
        # don't choose
        self.helper(nums, index + 1, list(path))
        
        # choose
        path.append(nums[index])
        
        self.helper(nums, index + 1, list(path))