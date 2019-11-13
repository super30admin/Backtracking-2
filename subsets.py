#Accepted on Leetcode
#Time complexity - O(N)
#Space complexity - O(N)

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        path = []
        #Edge case
        if len(nums) == 0 or nums == None:
            return res
        self.backtrack(nums,path,res,0)
        return res
    
    def backtrack(self,nums,path,res,index):
        res.append(path)
        
        for i in range(index,len(nums)):
            self.backtrack(nums,path+[nums[i]],res,i+1)