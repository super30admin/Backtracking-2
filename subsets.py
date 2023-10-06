class Solution:
    def subsets(self, nums):
        self.result = []
        def helper(index, path):
            if index == len(nums):
                self.result.append(list(path))
                return
            helper(index+1, path)
            path.append(nums[index])
            helper(index+1, path)
            path.pop()
        helper(0, [])
        return self.result
    
#TC: O(2^n)
#SC: O(n)