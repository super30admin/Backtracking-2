# Time Complexity: O(n * 2^n), n = length of input array, because each element can double the number of subsets
# Space Complexity: O(2^n), to store all subsets
# 1. Start with an empty subset and iteratively build all subsets by adding each number to existing subsets.
# 2. For each number, copy all existing subsets, add the current number, and append to the result.
# 3. At the end, the result contains all possible subsets of the input array.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        result.append([])
        for i in range(len(nums)):
            result_size = len(result)
            for j in range(result_size):
                temp = result[j].copy()
                temp.append(nums[i])
                result.append(temp)
            print(result)
        return result
        