#All TC passed on leetcode

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        #without recurrsion
         #Time complexity - O(2^N) where N- no. of  elements
        #Space complexity - O(N) i.e. each time temp holds one of subsets of res and max size of subset can go uptill size of nums
        if not nums:
            return res

        res = [[]]

        for i in range(len(nums)):
            for j in range(len(res)):
                temp = res[j].copy()
                temp.append(nums[i])
                res.append(temp)
        
        return res

#-------------------------------OR------------------------------------

        #choose/not choose approach
        #Time complexity - O(N*2^N) where N- no. of  elements, extra N for copying and creating new path each time
        #Space complexity - O(2^N) i.e. new path created for every recurrsive call
        if not nums:
            return []

        res = []

        def helper(nums, i, path):

            if i==len(nums):
                res.append(path.copy())
                return
            
            #not choose:
            helper(nums, i+1, path.copy())

            #choose:
            path.append(nums[i])
            helper(nums, i+1, path.copy())

        helper(nums, 0, [])
        return res



#----------------------------OR--------------------------------

        #Time complexity - O(2^N) where N- no. of  elements
        #Space complexity - O(N) i.e. max size of stack goes uptill no. of elements
        #for loop recurrsion approach
        if not nums:
            return []

        res = []

        def helper(nums, pivot, path):
            res.append(path.copy())

            for i in range(pivot, len(nums)):
                path.append(nums[i])
                helper(nums, i+1, path)
                path.pop()  #action -> recurse -> bactrack
        
        helper(nums, 0, [])
        return res
        