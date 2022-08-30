#  Time Complexity : O(2^n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode :yes
#  Any problem you faced while coding this : no

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result=[]
        def helper(nums, i, path):
            if i==len(nums):
                result.append(list(path))
                return
            #logic
            #not choose
            helper(nums, i+1, path)
            #choose
            path.append(nums[i])
            helper(nums, i+1, path)
            path.pop()
            
        helper(nums, 0, [])
        return result