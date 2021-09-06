"""
Time Complexity : O(N * 2^N) where N is no. of elements in an array
Space Complexity : O(N) where N is no. of elements in an array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        if len(nums) == 0:
            return self.result
        self.result.append([])
        # Loop through nums list
        for num in nums:
            # Capture the size because it will change later
            size = len(self.result)
            for i in range(size):
                # Get the first element and copy it to the temp and then append
                # current num to temp and after that append the temp to result
                temp = list(self.result[i])
                temp.append(num)
                self.result.append(temp)
        return self.result