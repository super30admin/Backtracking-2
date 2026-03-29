# problem 1 
# https://leetcode.com/problems/subsets/

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.final_arr = []
        self.nums = nums
        self.path = []
        self.helper(0)
        return self.final_arr


    def helper(self,i):
        if i == len(self.nums):
            self.final_arr.append(self.path.copy())
            return 
        self.helper(i+1)
        self.path.append(self.nums[i])
        self.helper(i+1)
        self.path.pop()
