def subsets(nums):
    result = [[]]

    def helper(nums, pivot, interim):
        for i in range(pivot, len(nums)):
            interim.append(nums[i])
            result.append(list(interim))
            helper(nums, i+1, interim)
            interim.pop()        

    helper(nums, 0, [])
    return result

nums = [1,2,3]
print(subsets(nums))