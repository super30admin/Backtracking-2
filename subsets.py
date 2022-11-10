# TC: O(n x 2^n) To generate all the subset
# SC: O(n x 2^n) To generate all the subset

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        output=[]
        
        
        def backtrack(first=0,curr=[]):
            if len(curr)==k:
                output.append(curr.copy())
                return
            
            for i in range(first,n):
                curr.append(nums[i])
                backtrack(i+1,curr)        
                curr.pop()
            
        
        n=len(nums)
        for k in range(n+1):
            backtrack()
            
        return output
        