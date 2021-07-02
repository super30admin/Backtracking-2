# Time complexity: O(n*2^n)
#Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        def helper(nums,index,path):
            #base
            #logic
            #create separate list for result as same reference added
            li = list(path)
            self.result.append(li)
            for i in xrange(index,len(nums)):
                #action to add to path
                path.append(nums[i])
                #recurse
                helper(nums,i+1,path)
                #backtrack
                path.pop()
        helper(nums,0,[])
        return self.result
                
        #backtracking
        # self.result = []
        # def helper(nums,index,path):
        #     #base
        #     if len(nums)==index:
        #         resPath = list(path)
        #         self.result.append(resPath)
        #         return
        #     #logic
        #     #not choose
        #     helper(nums,index+1,path)
        #     #choose
        #     li = list(path)
        #     li.append(nums[index])
        #     helper(nums,index+1,li)
        #     li.pop()
        # helper(nums,0,[])
        # return self.result