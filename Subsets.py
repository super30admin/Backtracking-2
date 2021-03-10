# TC: O(N * 2^N) 2^N subsets and N to add a subset to the result
# SC: O(N)
# LeetCode: Y(https://leetcode.com/problems/subsets)
# Approach: To generate a subset, we have to consider each element and execute 2 cases, 
#           Case 1: to not include element at currentIndex in the current Subset
#           Case 2 to include element at currentIndex in the current Subset

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        self.result = []
        
        self.backtrack(nums, 0, [])
        
        return self.result
        
    def backtrack(self, nums, currentIndex, currentSubset):
        
        # case of not choosing element at currentIndex
        self.result.append(currentSubset.copy())
        
        for i in range(currentIndex, len(nums)):
            # case of choosing element at currentIndex
            currentSubset.append(nums[i])
            
            # recurse
            self.backtrack(nums, i + 1, currentSubset)
            
            # backtrack
            currentSubset.pop()
            
        
