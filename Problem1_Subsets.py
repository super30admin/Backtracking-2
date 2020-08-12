#Backtracking-2
#Problem1 : https://leetcode.com/problems/subsets/
#All test cases passed on Leetcode
#Time Complexity:    O(2^n) -Exponential
#Space Complexity:    O(n) for Backtracking
class Solution:
    def __init__(self):
        self.result=[]
    #Approach used :backtracking 
    #Update the same list we call backtracking each time and whenever we have to append the result,we create a copy of the list and add.

    def backtrack(self,nums,temp,start):
        #cloning a list by using the builtin function list()
        self.result.append(list(temp))
        for i in range(start,len(nums)):
            #action
            temp.append(nums[i])
            #recurse
            self.backtrack(nums,temp,i+1)
            #backtrack
            temp.pop()
            
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        #edge cases
        if not nums or len(nums)==0:
            return result
        #call backtrack function
        self.backtrack(nums,[],0)
        return self.result
