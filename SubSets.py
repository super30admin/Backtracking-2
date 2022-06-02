#Time complexity: O(n*(2^n))
#Space complexity: O(2^n)
from collections import List
class Solution:
    res=[]
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res=[]
        self.helper(nums,0,[])
        return self.res
        
    def helper(self,nums,idx,path):
        self.res.append(path.copy())
        for i in range(idx,len(nums)):
            path.append(nums[i])
            self.helper(nums,i+1,path)
            path.pop()
        