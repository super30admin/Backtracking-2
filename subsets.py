'''
Time Complexity: O(2^n)
Space Complexity: O(n)

Approach: We use backtracking to explore all possible subsets of the given list. At each step, we have two choices: either include the current element in the subset or exclude it. We explore both choices recursively and add the resulting subsets to the final result.

'''
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        N = len(nums)
        res = []
        path = []
        def backtrack(index):
            if index>=N:
                res.append(path.copy())
                return 
            
            backtrack(index+1)
            path.append(nums[index])
            backtrack(index+1)
            path.pop()
        
        backtrack(0)
        return res

