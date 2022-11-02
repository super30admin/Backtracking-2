'''
Time Complexity: O(2^n)
Space Complexity: O(n)
'''
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        op =[[]]
        for i in range(len(nums)):
            sz = len(op)
            for j in range(sz):
                val = list(op[j])
                val.append(nums[i])
                op.append(val)
        return op
               