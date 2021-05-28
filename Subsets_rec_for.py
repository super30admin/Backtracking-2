# TC: O(2 ^ N) since we have 2 options for every number in the input list, to choose or not to choose. 
# SC: O(2 ^ N) as we are creating a new list every time we explore an option.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums or len(nums) == 0:
            return 
        
        self.result = []
        
        def helper(index, path):
            self.result.append(path)            
            for i in range(index, len(nums)):
                temp = path.copy()
                temp.append(nums[i])
                helper(i + 1, temp)
        helper(0, [])
        return self.result
