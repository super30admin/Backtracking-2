# 78. Subsets

# Code

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        
        def dfs(temp, i):
            res.append(temp[::])
            
            for x in range(i, len(nums)):
                temp.append(nums[x])
                # print(res, "Before: ", temp)
                dfs(temp, x+1)
                temp.pop()
                # print(res ,"After: ", temp)
            return
        
        dfs([], 0)
        return res

# Time Complexity: O(N*2^N)
# Space Complexity: O(N*2^N)
# Accepted on Leetcode: Yes
