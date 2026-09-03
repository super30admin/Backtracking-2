#Time Complexity: O(n*2^n) where n is the length of the input list nums
#Space Complexity: O(n*2^n) where n is the length of the input list nums]

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = [[]]

        for num in nums:
            size = len(result)
            for j in range(size):
                temp = result[j][:]
                temp.append(num)
                result.append(temp)

        return result
        