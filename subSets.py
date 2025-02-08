class Solution:
    # using concept of iterator
    # TC : exhaustive
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if nums is None:
            return []
        res = []
        res.append([])
        for i in range(len(nums)):
            size = len(res)
            for j in range(size):
                temp = res[j][:]
                temp.append(nums[i])
                res.append(temp)

        return res
        