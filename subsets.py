class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        def helper(curr, path):
            # base
            self.result.append(path.copy())

            # logic     
            for idx in range(curr, len(nums)):
                path.append(nums[idx])
                helper(idx+1, path)
                path.pop()


        helper(0, [])
        return self.result