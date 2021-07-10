# Time Complexity: O(n*2^n)
# Space Complexity: O(n)
class Solution(object):
    #     Defining the output array
    result = []

    # Created a backtrack function where we will iterate over current array with specific index and curr element
    # We will update the path and call same function recursivly and pop the
    # element in path and we will do this until base case is reached
    def backtrack(self, nums, index, path, curr):
        #         Base case
        if len(path) == index:
            self.result.append(path[:])
            return

        #       Logic
        for i in range(curr, len(nums)):
            path.append(nums[i])

            self.backtrack(nums, index, path, i + 1)

            path.pop()

    def subsets(self, nums):
        self.result = []

        for i in range(len(nums) + 1):
            self.backtrack(nums, i, [], 0)

        return self.result
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
