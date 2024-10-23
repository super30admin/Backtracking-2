# T.C = O(n2^n) S.C = O(n2^n)
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        self.helper(nums,0,[])
        return self.result

    def helper(self,nums,pivot,path):

        self.result.append(copy.deepcopy(path))

        for i in range(pivot,len(nums)):
            path.append(nums[i])
            self.helper(nums,i+1,path)
            path.pop(len(path)-1)
