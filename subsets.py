#78. Subsets
# Time Complexity : O(2^n) 
# Space Complexity :O(n) 
# Did this code successfully run on Leetcode : Yes
#take the 1st element of list then consider if not choosing we will keepon going untill we reach the last ele or leaf node . then recursion will pop automatically and go to choose cond where we add the corresponding element to result and will proceed with next elem in the list untill we reach the last ele.
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not list:
            return []
        self.result = []
        self.helper(nums,[],0)
        return self.result
    def helper(self,nums,temp,i):
        #base
        if i == len(nums):
            self.result.append(temp)
            return
        #not choose
        self.helper(nums,temp,i+1)
        #choose
        temp = temp + [nums[i]]
        self.helper(nums,temp,i+1)
		
# Time Complexity : O(2^n) 
# Space Complexity :O(n) 
# Did this code successfully run on Leetcode : Yes		
class Solution:
    result = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        self.result = []
        self.backtrack(nums,[],0)
        return self.result
    def backtrack(self,nums,temp,start):
        #base
        if start == len(nums):
            self.result.append(temp.copy())
            return
        self.result.append(temp.copy())
        for i in range(start,len(nums)):
            #action
            temp.append(nums[i])
            #recursive
            self.backtrack(nums,temp,i+1)
            #backtrack
            temp.pop()