# Time Complexity : Add - O(n*2^n)
# Space Complexity :O(n*2^n) - including recursive stack

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. I have used backtracking to explore all subset starting with singleton set

'''
class Solution:
    result = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        if not nums and len(nums) < 1:
            return
        
        self.result = []
        self._backtrack(nums, 0, [])
        
        return self.result
        
        
    def _backtrack(self, nums, index, path):
        
        
        self.result.append(path[:])
        for i in range(index,len(nums)):
            
            print (i, index)
            #action
            
            path.append(nums[i])
            
            #recurse
            self._backtrack(nums, i+1, path)
            
            _ = path.pop()
            