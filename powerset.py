
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
            if index ==n:
                result.append(list(path))
                return
                
            #dont choose
            helper(index+1,path)
            #choose
            path.append(nums[index])
            helper(index+1,path)
            path.pop()
            
            
        helper(0,[])
        
        return result