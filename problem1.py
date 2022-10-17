#subsets
#Space complexity:O(N)
#time : O(N)*2^N
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        current = []
        def dfs(i):
            if i>=len(nums):
                res.append(current.copy())
                return
            
            #decision to include
            current.append(nums[i])
            dfs(i+1)
            #decusion to exclude
            current.pop()
            dfs(i+1)
        
        dfs(0)
        return res
        