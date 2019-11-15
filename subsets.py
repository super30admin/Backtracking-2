"""
Leetcode:Accepted
#no doubts
time complexitty: 2^n
"""


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result=[]  
        self.helper(result,nums,0,list())
        return result
        
    def helper(self,result,nums,pos,templist):
        #you are appenind the empty list to the resultant list#
        
        # print("templist",templist)
        result.append(templist[:])
        # print("result",result)
       
       
        #if index keeps on incrementing and if it becomes equal to the lenght of the nums array, then return#
        if pos==len(nums):
            # print(">>>>>returing back when index is ",len(nums))

            return
    
    
        #iterating from the staritng element and keep on adding the element from the staring to end until it reaches base cas
        for i in range(pos,len(nums)):
            # print("index",i)
            # print("appending",nums[i])
            templist.append(nums[i])
            # print("after appending, templist",templist)
            
            # print("calling helper with index", i+1)
            # print("   ")
            self.helper(result,nums,i+1,templist)
            # print("____+++ index after returning+++____",i+1)
            #popping the last elemnt when it reaches the base case, and then doing the action from there onwards
            templist.pop()
            
            