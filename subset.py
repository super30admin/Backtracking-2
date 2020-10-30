class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if nums is None or len(nums)==0:
            return  []
        def recur(index,res,curr):   
            if len(curr)>len(nums): 
                return res
            res.append(deepcopy(curr))      
            for i in range(index,len(nums)):
                curr.append(nums[i])
                recur(i+1,res,curr)
                curr.pop()
            return res
                
        return recur(0,[],[])