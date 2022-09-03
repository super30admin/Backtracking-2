# 78. Subsets

'''
Leetcode all test cases passed: Yes
Solution:
    def subsets(self, nums):
        n is the length of nums
        h is height of tree
        Time Complexity: O(2 ^ n) 
        Space Complexity: O(h)
'''
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        
        res = []
        def dfs(curr,i):
            
                
            if i >= len(nums):
                res.append(curr)
                return
            
                
            dfs(curr + [nums[i]],i + 1 )
            dfs(curr,i + 1 )
        
        dfs([],0)
        return res
