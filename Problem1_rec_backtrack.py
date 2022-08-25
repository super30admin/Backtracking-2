# Time complexity : O(2^n)
# Space comeplexity : O(h)
# Leetcode : Solved and submitted

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        # if nums is null, then return empty list
        if not nums:
            return self.res
        
        # call the recusrsive function with path as empty list, starting with pivot as 0
        self.helper(nums, 0, [])
        return self.res
    
    def helper(self, nums, pivot, path):
        # Add the path to the result as we need all the permutations
        self.res.append(path[:])
        # logic
        # starting of for loop recursion starting from pivot till then end of nums
        for i in range(pivot, len(nums)):
            # action
            # append the element to the path
            path.append(nums[i])
            
            # recurse
            # recursively call the helper function by incrementing the pivot
            self.helper(nums, i+1, path)
            
            # backtrack
            # remove the last added element in the path
            path.pop()
        
