###
# Approach: 0-1 Recursion
# At each index, decide whether to include or exclude the current element.
# It builds a binary decision tree (include/exclude for every element).
# 
# Time: O(2^n * n)  - 2^n subsets, each copy takes O(n)
# Space: O(n)       - recursion depth
###
###
# Approach: For-loop + Recursion (Backtracking)
# Similar to combination logic. Each recursive call loops from current index.
# This avoids reusing previous elements and ensures combination-style subsets.
#
# Time: O(2^n * n)
# Space: O(n) recursion stack
###
###
# Approach: Iterative (No Recursion)
# Start with [[]], and for each element, add it to all existing subsets.
#
# Time: O(2^n * n)
# Space: O(2^n * n)
###
class Solution:
    def subsets_recursion_01(self, nums):
        res = []
        def helper(idx, path):
            if idx == len(nums):
                res.append(path[:])
                return
            helper(idx+1, path)
            path.append(nums[idx])
            helper(idx+1, path)
            path.pop()
        helper(0, [])
        return res
    
    def subsets_forloop(self, nums):
        res = []
        def helper(idx, path):
            res.append(path[:])
            for i in range(idx, len(nums)):
                path.append(nums[i])
                helper(i+1, path)
                path.pop()
        helper(0, [])
        return res
    
    def subsets_no_recursion(self, nums):
        res = [[]]
        for i in range(len(nums)):
            size = len(res)
            for j in range(size):
                sol = res[j] + [nums[i]]
                res.append(sol)
        return res

    def main(self):
        test_cases = [
            [1, 2, 3],
            [0]
        ]
        for nums in test_cases:
            print(f"\nInput: {nums}")
            print("Recursion 0-1:", self.subsets_recursion_01(nums))
            print("For-loop recursion:", self.subsets_forloop(nums))
            print("No recursion (iterative):", self.subsets_no_recursion(nums))

sol = Solution()
sol.main()