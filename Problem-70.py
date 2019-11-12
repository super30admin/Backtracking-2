# Leet code -78 - Subsets - https://leetcode.com/problems/subsets/
# Time complexity - O(2^n)
# Backtracking approach 

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res=[]
        path=[]
        index=0
        self.backtrack(nums,path,res,index)
        return res
    
    def backtrack(self,nums,path,res,index):
        res.append(path)
        
        for i in range(index,len(nums)):
            self.backtrack(nums,path+[nums[i]],res,i+1)
                
            
            