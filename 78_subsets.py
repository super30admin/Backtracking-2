from typing import List


class Solution:

    def __init__(self):
        self.result = []

    def subsets(self, nums: List[int]) -> List[List[int]]:
        """
            https://leetcode.com/problems/subsets/
            Time complexity - O(2^n)
                2^n is the number of number of power sets.
            Space complexity - O(n)
                'n' is the recursive stack space.
        """
        if not nums:
            return self.result
        self._backtrack(nums, [], 0)
        return self.result

    def _backtrack(self, nums: List[int], temp: List[int], idx: int) -> None:
        # base
        if idx > len(nums):
            return

        # logic
        self.result.append(list(temp))
        for i in range(idx, len(nums)):
            temp.append(nums[i])
            self._backtrack(nums, temp, i + 1)
            # backtrack
            temp.pop()


if __name__ == '__main__':
    h = Solution()
    print(h.subsets([1, 2, 3, 4]))
