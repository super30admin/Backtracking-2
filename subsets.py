# Runs on Leetcode

    # Time complexity - O(2^n), where n is length of nums
    # Memory complexity - O(1)


class Solution:
    def subsets(self, nums):
        if not nums:
            return []
        self.result = []
        self.helper(0,[],nums)
        return self.result
    
    def helper(self,start,temp,nums):
        if start > len(nums):
            return
        self.result.append(list(temp))
        for i in range(start,len(nums)):
            temp.append(nums[i])
            self.helper(i+1,temp,nums)
            temp.pop()
