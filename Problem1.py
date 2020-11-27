# Time Complexity : O(2^N) 
# Space Complexity : O(2^N) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Use backtack solve the probelm
# - In backtrack append the tempList to the answer and then parse through element from current index + 1 to end of list. 
# - Update the tempList and pass it to the backtrack function and again remove the value from the tempList.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
#       Initializing ans and calling backtarck function with empty list for tempList and 0 as start.
        self.backtrack(nums, [], ans, 0)
        return ans
        
    def backtrack(self, nums, tempList, ans, start):
#       Append the tempList to the answer
        ans.append(tempList)
#       Run for loop from satrt index to the end of the list.
        for i in range(start, len(nums)):
#           Append tempList with current indexed nums and call backtrack function. Because we are passing tempList after updating it as a parameter, it will be undone after function call.  
            self.backtrack(nums, tempList + [nums[i]], ans, i + 1)
