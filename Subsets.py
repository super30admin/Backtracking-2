#  Time Complexity : O(n*2^n)
#  Space Complexity : O(n) 
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : Start with an empty subset [] in result. For each number in nums, copy all existing subsets, add the current number to each copy, and append them back to result. Finally, result contains all possible subsets (the power set), so return it.

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