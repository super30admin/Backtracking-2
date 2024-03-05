'''
TC: O(N*2^N) - to generate all subsets and create deep copy for every subset created. 
SC: O(N*2^N)
'''
from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        #0/1 Recursion
        self.res = []

        def dfs(idx, path):
            #Base
            if idx == len(nums):
                self.res.append(list(path))
                return

            #Logic
            #Don't Choose
            dfs(idx+1, path)
            
            #Choose
            path.append(nums[idx])
            dfs(idx+1, path)
            path.pop()
        
        dfs(0, [])
        return self.res
s = Solution()
print(s.subsets([1,2,3]))
print(s.subsets([0]))