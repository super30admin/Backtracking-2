from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        #0/1 Recursion
        self.res = []

        def backtrack(idx, path):
            #Base
            self.res.append(list(path))
            #Logic
            for i in range(idx, len(nums)):
                path.append(nums[i])
                backtrack(i+1, path)
                path.pop()

        backtrack(0,[])
        return self.res
s = Solution()
print(s.subsets([1,2,3]))
print(s.subsets([0]))