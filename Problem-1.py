#Recursive solution
import copy
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        def helper(nums,index,temp):

            #base case

            if index == len(nums):
                result.append(copy.deepcopy(temp))
                return


            helper(nums,index+1,copy.deepcopy(temp))
            temp.append(nums[index])
            helper(nums,index+1,copy.deepcopy(temp))



        if nums is None or len(nums)==0:
            return []
        result=[]
        helper(nums,0,[])
        return result

#Backtracking
import copy
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        def backtrack(nums,index,temp):

            #base case
            result.append(copy.deepcopy(temp))

            for i in range(index,len(nums)):
                temp.append(nums[i])
                backtrack(nums,i+1,copy.deepcopy(temp))
                temp.pop()



        if nums is None or len(nums)==0:
            return []
        result=[]
        backtrack(nums,0,[])
        return result

        
