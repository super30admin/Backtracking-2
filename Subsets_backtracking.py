# TC: O(2 ^ N) since we are exploring 2 options for every number in the input list. 
# SC: O(N) where N is the space used by the path list. In worst case, it will be storing all input numbers, hence O(N).

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums or len(nums) == 0:
            return 
        
        self.result = []
        
        def helper(index, path):
            if index == len(nums):
                self.result.append(path.copy())
                return
            
#             dont choose
            helper(index + 1, path)
#               choose
#           action
            path.append(nums[index])
#           recurse
            helper(index + 1, path)
#           backtrack
            path.pop()
    
        helper(0, [])
        return self.result
