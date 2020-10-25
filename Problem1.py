class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        output = []
        if not nums or len(nums) == 0:
            return output
        def backtrack(out, index):
            output.append(list(out))
            for i in range(index, len(nums)):
                out.append(nums[i])
                backtrack(out, i+1)
                out.pop()
        backtrack([], 0)
        return output
