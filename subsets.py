# // Time Complexity : O(N* 2^N)
# // Space Complexity : O(N)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return [[]]

        self.result = []
        self.helper(nums, 0, [])
        return self.result

    def helper(self, nums, idx, path):
        # base
        # print(idx , path)
        if path not in self.result:
            self.result.append(list(path))
            # return
        # Logic
        for i in range(idx, len(nums)):
            path.append(nums[i])

            self.helper(nums, i + 1, path)

            path.pop()
        return