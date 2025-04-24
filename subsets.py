# - This is a classic backtracking approach that generates all subsets (the power set) by exploring inclusion/exclusion at each index.
# - For each element, we either include it in the current path or skip it, recursively building all possible combinations.
# - Time Complexity: O(2^n), Space Complexity: O(n) for recursion stack (where n is the length of nums).

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        def helper(nums, pivot, path):
            nonlocal result

            # add current subset to result
            result.append(path[:])

            for i in range(pivot, len(nums)):
                path.append(nums[i])
                helper(nums, i+1, path)
                path.pop()

        helper(nums, 0, [])
        return result
