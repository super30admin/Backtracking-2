# Time Complexity - O(N * 2^N)
# Space Complexity - O(N)

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        size = len(nums)
        result = []

        def generateSubsets(index, path):
            if index == size:
                result.append(path[:])
                return

            #  Not choose
            generateSubsets(index + 1, path)

            path.append(nums[index])

            # Choose
            generateSubsets(index + 1, path)

            path.pop()

        generateSubsets(0, [])

        return result
