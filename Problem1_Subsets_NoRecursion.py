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
# O(N): Max size of intermediate copy

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        result.append([])
        for curr in nums:
            size = len(result)
            for i in range(size):
                copy = list(result[i])
                copy.append(curr)
                result.add(copy)
        return result