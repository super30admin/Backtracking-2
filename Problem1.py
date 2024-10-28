#78 subsets
class Solution(object):
    def subsets(self, nums): #T.C -> O(2^N),S.C -> O(N)
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result = []
        self.dfs(nums,0,[])
        return self.result
    def dfs(self,nums,pivot,path):
        self.result.append(copy.deepcopy(path))

        #logic
        for i in range(pivot,len(nums)):
            temp = copy.deepcopy(path)
            temp.append(nums[i])
            self.dfs(nums,i+1,copy.deepcopy(temp))
            # path.pop()
    