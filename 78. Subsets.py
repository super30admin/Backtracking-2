# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(2^n)
# Space Complexity : Average : O(n), for recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    - use 0/1 recursion along with backtracking
    - a deep copy is added to output list at each
    - chose scenario to form a possible subset
    '''
    def subsets(self, nums: List[int]) -> List[List[int]]:
        output = []
        N = len(nums)
        output.append([])

        def backtracking(index, order):
            if index == N:
                return
            
            # selected
            order.append(nums[index])
            output.append(copy.deepcopy(order))
            backtracking(index+1, order)
            order.pop()

            # not selected
            backtracking(index+1, order)

        backtracking(0, [])
        return output