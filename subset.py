# Time Complexity : O(N.2^N) where N is the size of the list of nums
# Space Complexity : O(N.2^N) where N is the size of the recursion stack in the worst case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am creating an ans list to store the subsets.
# I am using a helper function to perform backtracking.
# The helper function takes the current path and the starting index as input.
# I append the current path to the ans list.
# I iterate through the nums list starting from the starting index to avoid duplicates.
# For each number, I append it to the current path and call the helper function recursively with the updated path and the next index.
# After the recursive call, I remove the last number from the current path to backtrack.
# Finally, I return the ans list.

from typing import List
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        def helper(path,idx):
            ans.append(path[:])
            for i in range(idx,len(nums)):
                path.append(nums[i])
                helper(path,i+1)
                path.pop()
        helper([],0)
        return ans

        