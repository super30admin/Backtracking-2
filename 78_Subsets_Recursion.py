# Time Complexity : O(2^n)[n = number of elements in the list]
# Space Complexity : O(2^n * n) [n = number of element in the list]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach
# 1. At each recusive call we have the option to either choose the element at current index or skip it
# 2. A new list is created for each recusive call
# 3. The recusion terminates when the index reaches the length of the input list
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        def helper(nums, index, curr):
            nonlocal res
            ## base
            if index == len(nums):
                res.append(curr)
                return
            
            ## body
            
            # don't choose
            helper(nums, index+1, curr)
            
            # choose
            new_list = [num for num in curr]
            new_list.append(nums[index])
            helper(nums, index+1, new_list)
        helper(nums, 0, [])
        return res