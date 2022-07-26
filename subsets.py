#Time Complexity: O(2**n) where 2 is the number of choices and n is the number of levels
#Space Complexity: O(n)
#For loop recursion with backtracking
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result=[]
        self.helper(nums, 0, [])
        return self.result
    def helper(self, nums, index, path):
        self.result.append(path[:])
        for i in range(index, len(nums)):
            path.append(nums[i])
            self.helper(nums, i+1, path)
            path.pop()
# 0-1 recursion        
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result=[]
        self.helper(nums, 0, [])
        return self.result
    def helper(self, nums, i, path):
        if i==len(nums):
            self.result.append(path)
            return 
        #Dont choose
        self.helper(nums, i+1, path[:])
        #choose
        path.append(nums[i])
        self.helper(nums, i+1, path[:])