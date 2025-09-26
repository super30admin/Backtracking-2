def subsets(self, nums: List[int]) -> List[List[int]]:
    result=[]
    path=[]
    
    def helper(pivot):
        result.append(path[:])
        for i in range(pivot, len(nums)):
            path.append(nums[i])
            helper(i+1)
            path.pop()

    helper(0)
    return result
