# The subsets function generates all subsets of a given list using backtracking. It iterates through the list and 
# recursively explores each possible subset, adding it to the result.

# Time Complexity: O(2^n), where n is the length of the input list (since there are 2^n subsets).
# Space Complexity: O(n), for the recursion stack used by backtracking and the space required for the subsets.
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.output = []
        self.n = len(nums)
        self.backtrack(0, [], nums)
        return self.output

    def backtrack(self, first, curr, nums):
        self.output.append(curr[:])
        for i in range(first, self.n):
            curr.append(nums[i])
            self.backtrack(i + 1, curr, nums)  
            curr.pop()      