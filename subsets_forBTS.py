class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        def helper(index, path):
            result.append(path[:])

            for i in range(index, len(nums)):
                path.append(nums[i])
                helper(i+1, path)
                path.pop()
        
        helper(0, [])
        return result

        