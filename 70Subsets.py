"""
// Time Complexity :O(n*2^n) Visiting each node ones.
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NA

//Explanation:
Take pivot from the input nums list. and follow-
action -> add nums[0] in temp list.
recursion -> recurse on nums[0+1]
backtrack -> pop the element from the temp list.

#recursive approach
Follow above 3 steps.
create new list at each recursive state.
No need to backtrack as we are creating new list everytime.(Consumes more space)
"""
class Solution:
    def __init__(self) :
        self.result = []
        self.temp = []

    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums is None or len(nums) == 0:
            return []

        self.backtrack(nums,[ ],0)
        return self.result

    def backtrack(self,nums,temp,index):
            #base
            #logic
            self.result.append(list(temp))

            for i in range(index,len(nums)):
                #action
                self.temp.append(nums[i])
                #recursion
                self.backtrack(nums,self.temp,i+1)
                #backtrack
                self.temp.pop()
"""
# recursive solution
def backtrack(self,nums,temp,index):
        if index == len(nums):
            self.result.append(list(self.temp))
            return
        # logic
        # don't choose case
        self.backtrack(nums,list(self.temp),index +1 )
        # choose case
        self.temp.append(nums[index])

        self.backtrack(nums,list(self.temp),index + 1)
        self.temp.pop()
"""
