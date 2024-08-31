# time: O(n)
# space: O(h)
class Solution(object):
    result = []
    def subsets(self, nums):
        self.result = []
        self.helper(nums, 0, [])
        return self.result
    
    def helper(self, nums, index, path):
        if index >= len(nums):
            path_new = []
            path_new += path
            self.result.append(path_new)
            return
        # dont choose
        self.helper(nums, index+1, path)
        # choose
        path.append(nums[index])
        self.helper(nums, index+1, path)
        path.pop()

        