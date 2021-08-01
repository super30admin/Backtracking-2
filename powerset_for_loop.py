#Time Complexity :  O(exponential))
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        
        if len(nums)==0:
            return []
        result = []
        n = len(nums)
 
        def helper(index,path):
            result.append(list(path))
            for i in range(index,n):
                path.append(nums[i])
                helper(i+1,(path))
                path.pop()
        # result.append([])  
        helper(0,[])
        
        return result