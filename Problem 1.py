# Time: O(n*n)
# Space: O(n*n)
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ans = [[]]
        self.helper(0, ans, [], nums)
        return ans
    def helper(self, ind, ans, curr, nums):
        if ind == len(nums):
            return
        for i in range(ind, len(nums)):
            #print(i)
            curr.append(nums[i])
            ans.append(list(curr))
            #print(curr)
            self.helper(i+1, ans, curr, nums)
            curr.pop()
        return
        
