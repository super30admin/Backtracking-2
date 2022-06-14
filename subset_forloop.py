# Time Complexity : O(N^N) where is N is number of elements
# Space Complexity : O(1) where N is number of elements
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        
        for i in range(len(nums)):
            size = len(result)
            j = 0
            while j < size:
                temp = result[j][:]
                temp.append(nums[i])
                result.append(temp)
                j += 1
        
        return result