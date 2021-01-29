'''
    Time Complexity:
        O(n*2^n)
        (2^n because at each step we are either choosing or not choosing)
        (n because additionally, at each step we are creating a deepcopy of the current array)

    Space Complexity:
        O(n)
        (this is the only additional stack trace memory this algorithm uses)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Backtracking
'''
class Solution:
    def __init__(self):
        self.nums = []
        self.all_subsets = []

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.nums = nums
        self.generate_subsets(0, [])
        return self.all_subsets

    def generate_subsets(self, idx, curr):
        self.all_subsets.append(copy.deepcopy(curr))

        for i in range(idx, len(self.nums)):
            curr.append(self.nums[i])
            self.generate_subsets(i + 1, curr)
            curr.pop()
