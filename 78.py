
# Time Complexity : O(2^n)
# space Complexity : O(n * 2ⁿ)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        def rec(nums, index, path):
            if index == len(nums):
                result.append(list(path))
                return

            rec(nums, index +1 , list(path))
            path.append(nums[index])
            rec(nums, index +1, list(path))
        rec(nums, 0, [])
        return result