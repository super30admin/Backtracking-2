class Solution:
    def subsets(self, nums):
        res=[]
        subset=[]
        
        
        def backtrack(i):
            if i>=len(nums):
                res.append(subset.copy())
                return res
            
            subset.append(nums[i])
            backtrack(i+1)
            
            subset.pop()
            backtrack(i+1)
            
        backtrack(0)
        return res

## Time Complexity: O(N*(2**N))
## Space Complexity : O(N)