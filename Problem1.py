#time:
#space:
class Solution(object):
    def sub(self,nums,start,curr,res):
        
        if start > len(nums):
            return 
        res.append(list(curr))
        
        for i in range(start,len(nums)):
            curr.append(nums[i])
            self.sub(nums,i+1,curr,res)
            curr.pop()
    def subsets(self, nums):
        curr = []
        res = []
        self.sub(nums,0,curr,res)
        return res
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        