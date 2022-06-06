#Time Complexity: Exponential
#Space Complexity: Exponential
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for i in range(len(nums)):
            length = len(result)
            for j in range(length):
                temp = result[j].copy()
                temp.append(nums[i])
                result.append(temp)
                
        return result
        