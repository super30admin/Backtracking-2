# // Time Complexity : O(n * 2^n)
# // Space Complexity : O(N^2)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
    # Choose or not choose apply recursion

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        if not nums:
            return self.res
        combi = []
        self.helper(nums,0,combi)
        return self.res
    
    def helper(self,nums,index,combi):
        ## Base logic
        if index == len(nums):
            self.res.append(combi)
            return
        ## Recursion
        
        self.helper(nums,index+1,combi.copy())
        combi.append(nums[index])
        self.helper(nums,index+1,combi.copy())

# // Time Complexity : O(n * 2^n)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
    # Choose or not choose apply recursion with back tracking
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        if not nums:
            return self.res
        combi = []
        self.helper(nums,0,combi)
        return self.res
    
    def helper(self,nums,index,combi):
        ## Base logic
        if index == len(nums):
            self.res.append(combi.copy())
            return
        ## Recursion
        
        self.helper(nums,index+1,combi)
        combi.append(nums[index])
        self.helper(nums,index+1,combi)
        
        combi.pop()

# // Time Complexity : O(n * 2^n)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
    # Choose or not choose apply recursion with back tracking using for loop
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        if not nums:
            return self.res
        combi = []
        self.helper(nums,0,combi)
        return self.res
    
    def helper(self,nums,index,combi):
        self.res.append(combi.copy())
        ## Recursion
        for i in range(index,len(nums)):
            combi.append(nums[i])
            self.helper(nums,i+1,combi)
            combi.pop()