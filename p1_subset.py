class Solution:
    """
    Time Complexity: n * 2 ^ n
    Space Complexity: O(N)

    Approach: 
        - We take backtracking approach
        - we recurse until we go out of bound with the pivot
        - and we add all the paths along the way 
    """
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = list()
        self.helper(nums, [], 0)
        return self.result
    
    def helper(self, nums, path, pivot):
        # Base
        self.result.append(path.copy())
        if pivot == len(nums):
            return 

        # Logic
        for i in range(pivot, len(nums)):
            # Action
            path.append(nums[i])
            # Recurse
            self.helper(nums, path, i+1)
            # Pop
            path.pop()