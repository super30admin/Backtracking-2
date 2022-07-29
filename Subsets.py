# Time Complexity => O(N*x^N) Exponential
# Space Complexity => O(N)
from pip import List
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        path = []
        def helper(nums, index, path):
            result.append(path.copy())
            for i in range(index, len(nums)):
                path.append(nums[i])
                helper(nums, i+1, path)
                print(index)
                path.pop()
        helper(nums,0,path)
        return result
            
        