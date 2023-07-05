#Time complexity is O(2^n) where n is the total number of subsets created for n elements
#Space complexity is O(2^n) where n is the total number of subsets created for n elements
#Code ran successfully on leetcode
#No issues faced while coding

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        #Creating an empty list to store the resut
        self.result=[]
        self.helper(nums,0,[])
        return self.result

    def helper(self,nums,i,path):
        #base
        #If the base condition is satisfies, we will add the path to the result list
        if(i==len(nums)):
            self.result.append(list(path))
            return
        #not choose
        #If we are not choosing, we will not add the nums[i] to the path
        self.helper(nums,i+1,path)
        #choose
        #If we are choosing the value, we will add that to the path
        path.append(nums[i])
        #recursive call
        self.helper(nums,i+1,path)
        #backtrack
        #As a part of backtracking step, we will pop the values from the path
        path.pop()