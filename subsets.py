# Time complexity: O(n^n) where n is the length of the list
# Space complexity: O(n)
# Approach: use for loop based recursion and keep adding the numbers one by one, two by two until length by length by recursing, and do backtrack.


class Solution:
    result = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.helper(nums, 0, [])
        return self.result
    
    def helper(self,nums, index, path):
        #base
        self.result.append(path.copy())
        
        #logic
        #action
        for i in range(index, len(nums)):
            path.append(nums[i])
        
        
        #recursion
            self.helper(nums,i+1,path)
        
        #backtrack:
            path.pop()
        
    
        
        