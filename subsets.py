class Solution(object):
    res=[]
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        :SC: O(n*(n^2))
        :TC: O(n^2)
        """
        # DFS or recursive
        if not nums: return res

        self.helper(nums, 0, [])
        return self.res
    
    def helper(self, nums, index, path):
        # base
        if index==len(nums):
            self.res.append(path)
            return
        
        # logic
        # not choose
        cp=path[:]
        self.helper(nums, index+1, cp)
        # choose
        path.append(nums[index])
        cp=path[:]
        self.helper(nums, index+1, cp)
        

        
        
        
        