# Time Complexity: O(N*2^N)
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res=[]
        path=[]

        def helper(idx):
            #base
            if idx==len(nums):
                res.append(path[:])
                return

            #logic
            helper(idx+1)

            path.append(nums[idx])
            helper(idx+1)
            path.pop()
        
        helper(0)
        return res

