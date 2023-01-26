class Solution:
    # def subsets(self, nums: List[int]) -> List[List[int]]:
        # list1=[[]]
        # for i in range(0,len(nums)):
        #     for j,k in zip(nums[i:],range(i+1,len(nums)+1)):
        #         list1.append(nums[i:k])
        # print(list1)
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def dfs(nums, res, path):
            if not nums:

                res.append(path)
                return
            dfs(nums[1:], res, path) # ignore the current element
            dfs(nums[1:], res, path+[nums[0]]) # select the current element
        
        res  = []
        dfs(nums, res, [])
        return res  