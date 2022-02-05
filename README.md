# Backtracking-2

## Problem1 
Subsets (https://leetcode.com/problems/subsets/)

# Time COmplexity=Exponential
# Space COmplexity=O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def fun(path,index,nums):
            a=path.copy()
            result.append(a)
            if index==len(nums):
                return
            for i in range(index,len(nums)):
                path.append(nums[i])
                fun(path,i+1,nums)
                path.pop()
        global result
        result=[]
        fun([],0,nums)
        return result
                
                
        

## Problem2

Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)


class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        def isPalindrome(start_ind, end_ind):
            while start_ind <= end_ind:
                if s[start_ind] != s[end_ind]: return False
                start_ind += 1
                end_ind -=1
            return True
        
        def dfs(start_ind, path):
            if start_ind >= len(s): self.res.append(path)
                
            for l in range(len(s) - start_ind):
                if isPalindrome(start_ind, start_ind + l):
                    dfs(start_ind + l + 1, path + [s[start_ind:start_ind + l + 1]] )
        
        self.res = []
        dfs(0,[])
        return self.res