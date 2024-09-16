#Time Complexity:O(2^N)
#Space Complexity:O(2^n)
#Ran sucessfully on Leetcode: Yes
#Algorithm:
# 1. Create a array for returning result
# 2. Create a helper function, with the given list , current list being returned as result, index of the element in nums we are dealing with. 
# 3. In the helper function we append the elements in nums to the result every time we call the function.
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result=[]
        self.helper(nums,result,[],0)
        return result
    def helper(self,nums,result,curr,index):
        result.append(list(curr))
        for i in range(index,len(nums)):
            curr.append(nums[i])
            self.helper(nums,result,curr,i+1)
            curr.pop()
            
