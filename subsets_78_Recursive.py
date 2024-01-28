"""
Time Complexity = O(2^n)
Space Complexity = O(2^n)
"""

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        return dfs(0, nums, [], []) 


def dfs(i, nums, currentSet, res):

    # i is at the last element, then add the node to the res list
    if i == len(nums):
        if currentSet not in res:
            res.append(currentSet)
        return

        #Choose the element
    dfs(i + 1, nums, currentSet + [nums[i]], res)

        #not choose the element
    dfs(i + 1, nums, currentSet, res)    
    return res

