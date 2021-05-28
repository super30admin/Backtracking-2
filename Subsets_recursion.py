# TC: O(2 ^ N) since we have 2 options for every number in the input list, to choose or not to choose. 
# SC: O(2 ^ N) as we are creating a new list every time we explore an option.


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums or len(nums) == 0:
            return 
        
        self.result = []
        
        def helper(index, path):
            if index == len(nums):
                self.result.append(path)
                return
            
#             dont choose
            helper(index + 1, path)
#               choose
            temp = path.copy()
            temp.append(nums[index])
            helper(index + 1, temp)
        
        helper(0, [])
        return self.result
