# Subsets (https://leetcode.com/problems/subsets/)

# Time Complexity : O(n * 2^n)
# Space Complexity : O(n * 2^n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


############ 0 - 1 recursion with backtracking #############

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.helper(nums,0,[],self.res)
        return self.res
    
    def helper(self,nums,idx,path,res):
        # base
        if idx == len(nums):
            self.res.append(path.copy())
            return

        # logic
        self.helper(nums,idx+1,path,self.res)


        path.append(nums[idx])
        self.helper(nums,idx+1,path,self.res)
        path.pop()
        

############# for loop recursion with backtracking ###################

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.helper(nums,0,[],self.res)
        return self.res
    
    def helper(self,nums,pivot,path,res):
        # base

        # logic 
        self.res.append(path.copy())
        for i in range(pivot, len(nums)):
            path.append(nums[i])
            self.helper(nums,i+1,path,self.res)
            path.pop() # backtracking
        

# TC: O(n * 2^n) - n for the copy oh the list everytime and 2^n nodes will be created
# SC: O(n * 2^n)