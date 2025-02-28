class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result =[]
        def subsetsHelper(index,curr):
            if index==len(nums):
                result.append(curr)
                return
            subsetsHelper(index+1,curr+[nums[index]])
            subsetsHelper(index+1,curr)
        

        subsetsHelper(0,[])
        return result