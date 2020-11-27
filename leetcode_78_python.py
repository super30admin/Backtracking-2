class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        output=[]
        level=0
        self.backtrack(nums,output,[],0)
        return output
    def backtrack(self,nums,output,subset,level):
        output.append(list(subset))
        for i in range(level,len(nums)):
            subset.append(nums[i])
            self.backtrack(nums,output,subset,i+1)
            subset.pop()