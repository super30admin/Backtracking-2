# Time Complexity :O(2^n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No


import copy
class Solution(object):
    def subsets(self, nums):
        result=[]
        
        self.rec(0,nums,[],result)
        return result
    def rec(self,i,nums,path,result):
        # Base
        if(i==len(nums)):
            k=copy.deepcopy(path)
            result.append(path)
            return

        #Not Choose
        self.rec(i+1,nums,path,result)
        #Choose
        self.rec(i+1,nums,path+[nums[i]],result)
        