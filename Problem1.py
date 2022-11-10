#Time Complexity - O(2^n)
#Space Complexity - O(n)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        def explore( index, target, arr):
            nonlocal result
            if target == 0:
                result.append(arr.copy())
                return
            if index >= len(candidates) or target < 0:
                return
            for i in range(index, len(candidates)):
                target -=  candidates[i]
                arr.append(candidates[i])
                explore(i, target, arr)
                target += arr.pop()
            
        explore(0, target, [])
        return result

    