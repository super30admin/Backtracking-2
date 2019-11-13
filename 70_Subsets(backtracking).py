# Passed on leetcode(78)
# time - O(2^N), space - O(N)
# At every step go till end and add all elements and then backtrack at each point and then add all elements.
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        # edge case
        if len(nums) == 0: return result
        self.backtrack(nums, [], 0, result)  # call recursive function
        return result

    def backtrack(self, nums, temp, start, result):
        # Base case with no condition as we have to add all the elements
        result.append(temp[:])
        # Loop for each element and increase the start each time the recrsion is called.
        for i in range(start, len(nums)):
            temp.append(nums[i])
            self.backtrack(nums, temp, i + 1, result)
            temp.pop(-1)