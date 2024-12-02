# TC: O(2^n+m)
# SC: O(n+m)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
         self.res = []
         def helper(candidates, target, pivot, path):
            if target == 0:
                self.res.append(path[:])
                return
            
            if pivot == len(candidates) or target < 0:
                return
            
            for i in range(pivot, len(candidates)):
                path.append(candidates[i])
                helper(candidates, target - candidates[i], i, path)
                path.pop()

         helper(candidates, target, 0, [])
         return self.res

         
