## Problem1: Subsets (https://leetcode.com/problems/subsets/)
# Time Complexity: O(n x 2^n), There are 2^n subsets total because each number has 2 choices, include or skip. For each subset we spend up to O(n) time to copy the path into the result list.
# Space Complexity: O(n),The path list and the recursion call stack both grow up to size n at the deepest point.This does not count the space used by the result list itself, since that is the output.
# Approach:
# We build subsets by deciding for each number whether to skip it or include it.
# We first explore skipping the number, then come back and explore including it.
# When we reach the end of nums, whatever is in path right now is one complete subset, so we save a copy of it.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []            # this will hold all the subsets we find
        path = []                   # this holds the subset we are currently building

        def helper(i: int) -> None:
            if i == len(nums):
                # we have made a decision for every number, so path is a complete subset now
                self.result.append(path.copy())  # save a copy, not path itself, since path keeps changing
                return

            # skip choice, we do not add nums[i], just move to the next index
            helper(i + 1)

            # include choice, we add nums[i] to path first
            path.append(nums[i])  # add nums[i] to the current subset
            helper(i + 1)  # explore all subsets that include nums[i]
            path.pop()  # remove nums[i] so path goes back to how it was before, ready for other choices

        helper(0)  # start deciding from index 0, path is empty at this point
        return self.result