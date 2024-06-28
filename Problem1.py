'''
1. We use backtracking to create subsets. We start with index 0 and an empty array.
2. We increment the index when we are going deeper as elements cannot be repeated in a set. Once that level is completed we perform the pop to remove that element and move to next one.

TC: O(2^N * N) since N elements can have 2^N subsets and for each of this, maximum length of array is N
SC: O(2^N * N) since result set has 2^N elements and each one has max length of N
'''

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        if not nums or len(nums) == 0:
            return []

        self.result = []
        self.backtrack(nums, 0, [])        
        return self.result

    
    def backtrack(self, nums, index, path : List[int]) -> None:
   
        self.result.append(path.copy())

        for i in range(index,len(nums)):
            path.append(nums[i])
            self.backtrack(nums,i + 1, path)
            path.pop()