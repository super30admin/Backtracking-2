#TC: O(N*2^N)
#SC: O(N*2^N)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # Without Backtracking
        def helper(list1, idx):
            #base
            self.res.append(list1)

            for i in range(idx, n):
                li = list(list1)
                li.append(nums[i])
                helper(li, i+1)
                # list1.pop()

        self.res = []
        n = len(nums)
        helper([], 0)
        return self.res
