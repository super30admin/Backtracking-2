#TIme COmplexity:O(n^n)
#Space COmplexity:O(n)
#Leetcode submission:successful

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        output=[]
        index=0
        self.backtrack(nums,output,[],0)
        return output
    def backtrack(self,nums,output,subset,index):
        output.append(list(subset))
        for i in range(index,len(nums)):
            subset.append(nums[i])
            self.backtrack(nums,output,subset,i+1)
            subset.pop()