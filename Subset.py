class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        #exponential
        #O(N)
        res=[]
        if not nums:
            return res
        def helper(nums,index,temp):
            #store copy of temp as otherwise till end tafter removal, temp will be eventually empty
            res.append(temp[:])
            #for every index, try to run throughout length of nums and go till end>base>then backtrack
            for i in range(index,len(nums)):
                temp.append(nums[i])
                #print(temp,i,index)
                helper(nums,i+1,temp)
                temp.pop()
            
        helper(nums,0,[])  
        return res