# leetcode 78
# time -
# space -
class Solution(object):
    def subsets(self, nums):
        res = []
        path = []
        # index=0
        self.helper_backtrack(nums, 0, path, res)
        return res

    def helper_backtrack(self, nums, index, path, res):
        res.append(path)
        for i in range(index, len(nums), 1):
            self.helper_backtrack(nums, i + 1, path + [nums[i]], res)
            # self.helper_backtrack(nums,i,path+[nums[i]],res)


class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res=[]
        path=[]
        index=0
        self.backtrack(nums,path,res,index)
        return res

    def backtrack(self,nums,path,res,index):
        res.append(path)

        for i in range(index,len(nums)):
            self.backtrack(nums,path+[nums[i]],res,i+1)