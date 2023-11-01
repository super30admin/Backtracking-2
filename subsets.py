# // Time Complexity :O(n2^n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we are implementing this in 3 ways - o/1 recursions and for loop recursion and superset algorithm
# we choose and not choose each element in the array and get all possible subsets
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # 0-1 based recursion O(n2^n)
        def helper(nums, idx, path):
            # base
            if(idx==len(nums)):
                res.append(list(path))
                return

            # logic
            # not choose
            helper(nums, idx+1, path)
            # choose
            # action
            path.append(nums[idx])
            # recurse
            helper(nums,idx+1, path)
            # backtrack
            path.pop()
        # for loop based recursion
        def helper_new(nums, pivot, path):
            
            # logic
            res.append(list(path))
            for i in range(pivot, len(nums)):
                # action
                path.append(nums[i])
                # recurse
                helper_new(nums, i+1, path)
                # backtrack
                path.pop()
            
        res=[]
        # helper(nums, 0, [])
        helper_new(nums, 0, [])
        return res

        # superset algorithm 
        # res=[]
        # res.append([])
        # for i in range(len(nums)):
        #     k=len(res)
        #     for j in range(k):
        #         li=list(res[j])
        #         li.append(nums[i])
        #         res.append(li)
        # return res