#time comp: n * 2^n 
#space: O(n) 


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        def helper(nums, i , arr):
            #base condition
            if (i==len(nums)):
                result.append(arr)
                return
            #if not choose
            helper(nums, i+1, arr.copy())
            #if choose 
            arr.append(nums[i])
            helper(nums, i+1 , arr.copy())

        
        if len(nums) ==0:
            return 
        result=[]
        helper(nums, 0, [])
        return result
        