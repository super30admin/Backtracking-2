class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]

        for i in range(len(nums)):
            for j in range(len(result)):
                temp = result[j][:]
                temp.append(nums[i])
                result.append(temp)
        
        return result
        