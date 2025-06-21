# Time Complexity : O(2^n * n)
# - O(2^n) — Total number of subsets for a list of length n (each element is either chosen or not)
# - Each subset can take O(n) time to copy via path[:] when added to the result
#
# Space Complexity : O(n) recursion stack + O(2^n * n) for the output list
# - O(n) recursion stack depth (one call per element)
# - O(2^n * n) to store all subsets in the final result list
#
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        # 1. Backtracking (include/exclude style)
        res = []

        def backtrack(idx, path):
            if idx == len(nums):
                res.append(path[:])  # copy the current subset
                return

            # Exclude nums[idx]
            backtrack(idx + 1, path)

            # Include nums[idx]
            path.append(nums[idx])     # action
            backtrack(idx + 1, path)   # recurse
            path.pop()                 # backtrack

        backtrack(0, [])
        return res

        # --------------------------------------------------------
        # 2. For-loop with Backtracking (classic DFS structure)
        # Time: O(2^n * n), Space: O(n) stack + O(2^n * n) result
        #
        # res = []
        # def dfs(pivot, path):
        #     res.append(path[:])
        #     for i in range(pivot, len(nums)):
        #         path.append(nums[i])    # action
        #         dfs(i + 1, path)        # recurse
        #         path.pop()              # backtrack
        # dfs(0, [])
        # return res

        # --------------------------------------------------------
        # 3. For-loop Recursion (no backtracking, pure recursion)
        # Time: O(2^n * n), Space: O(2^n * n) due to new list at every level
        #
        # res = []
        # def dfs(pivot, path):
        #     res.append(path[:])
        #     for i in range(pivot, len(nums)):
        #         new_path = path + [nums[i]]  # no mutation, creates new list
        #         dfs(i + 1, new_path)
        # dfs(0, [])
        # return res

        # --------------------------------------------------------
        # 4. Pure Recursive (include/exclude, no backtrack)
        # Time: O(2^n * n), Space: O(n) recursion + O(2^n * n) result
        #
        # res = []
        # def helper(idx, path):
        #     if idx == len(nums):
        #         res.append(path[:])
        #         return
        #     li = path[:]
        #     li.append(nums[idx])
        #     helper(idx + 1, li)    # include
        #     helper(idx + 1, path)  # exclude
        # helper(0, [])
        # return res


# Example usage:
if __name__ == "__main__":
    sol = Solution()
    print(sol.subsets([1, 2, 3]))  
    # Expected output (order may vary):
    # [[], [3], [2], [2,3], [1], [1,3], [1,2], [1,2,3]]

    print(sol.subsets([]))  
    # Expected output: [[]]  (only the empty subset)

    print(sol.subsets([0]))  
    # Expected output: [[], [0]]

    print(sol.subsets([1, 2]))  
    # Expected output: [[], [2], [1], [1, 2]]

    print(sol.subsets([4, 5, 6, 7]))  
    # Expected output: all subsets of [4,5,6,7] (16 subsets total)
