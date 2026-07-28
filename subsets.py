from typing import List
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]

        for num in nums:
            size = len(result)
            for j in range(size):
                temp = result[j][:]
                temp.append(num)
                result.append(temp)

        return result

# TC - O(n*2^n)
# SC - O(n)