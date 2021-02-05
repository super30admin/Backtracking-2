# -*- coding: utf-8 -*-
"""
TC : O(2 power N) where N is the number of elements in the given array
SC : recursive stack used
"""

class Solution:
    li = []
    def subsets(self, nums: List[int]) -> List[List[int]]:
        #edge case
        if not nums or len(nums) == 0:return self.li
        
        self.backtracking(nums,[],0)
        return self.li
    
    #we define a backtracking function that will recursively call on the temporary list 
    #at every index, we make a choice of either choosing the elemnt or not choose
    #we append the temp path to the list once length of array has reached
    def backtracking(self,nums:[],temp:[],index:int):
       #base case
        if index == len(nums):
            self.li.append(list(temp))
            return       
                
        #logic
        #dont choose
        self.backtracking(nums,temp,index + 1)
        
        #choose
        #action
        temp.append(nums[index])
        #recurse
        self.backtracking(nums,temp,index + 1) 
        #backtrack
        temp.remove(nums[index])
