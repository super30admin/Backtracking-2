#Time Complexity : O(2^N)
#Space Complexity :O(N)
#Did this code successfully run on Leetcode : yes

from ast import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        curr_subset = []
        def dfs_helper(i):
            if i >= len(nums):
                result.append(curr_subset.copy())
                return 

            # to choose
            curr_subset.append(nums[i])
            dfs_helper(i+1)

            #not choose
            curr_subset.pop()
            dfs_helper(i+1)
        
        dfs_helper(0)
        return result
        