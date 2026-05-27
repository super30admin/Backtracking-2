# Time Complexity : O(n*2^n) n: number of elements.
# Space complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach
# Traverse a recursive decision tree where at each index having two choices: exclude the current number, or include it.
# When the index reaches the end of the input array current path will be complete, valid subset — copy to results.
# After exploring the "choose", remove the current number from the path to clean the state before the function returns, allowing other branches to use a fresh path.


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        self.result = []
        path = []

        def helper(index:int):
            if index == len(nums):
                self.result.append(path.copy())
                return

            #no choose
            helper(index+1)

            #choose
            path.append(nums[index])
            helper(index+1)
            path.pop()

        helper(0)
        return self.result