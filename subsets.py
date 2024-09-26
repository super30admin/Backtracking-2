# // Time Complexity :(O((2^n)/2)),for backtracking
# // Space Complexity :(O(1)) or backtracking,O(n) for recursion
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


import copy
class Solution:
    def __init__(self):
        self.result=[]
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result.append([])
        
        self.helper(nums,0,[])
        return self.result
    def helper(self,nums,index,path):
        if index==len(nums):
            return
        
        for i in range(index,len(nums)):
            path.append(nums[i])
            self.helper(nums,i+1,path)
            li=copy.copy(path)
            self.result.append(li)
            path.remove(path[-1])
            
        