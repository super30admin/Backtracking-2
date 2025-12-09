class Solution(object):
    def subsets(self, nums):
        """
        Time Complexity: O(N * 2^N) where N is the length of nums
        Space Complexity: O(N) for the recursion stack
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []

        def backtrack(start, path):
            #No base case
            res.append(path[:])

            #Logic
            for i in range(start, len(nums)):
                path.append(nums[i])
                backtrack(i+1, path)
                path.pop()
        
        backtrack(0, [])
        return res