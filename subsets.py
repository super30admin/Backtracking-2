from typing import List


# Approach 1: Iterative
# TC: O(2^n), SC: O(2^n)
def subsets_iterative(nums: List[int]) -> List[List[int]]:
    result = [[]]
    for num in nums:
        size = len(result)
        for i in range(size):
            temp = result[i] + [num]
            result.append(temp)
    return result


# Approach 2: Backtracking (For loop based)
# TC: O(2^n), SC: O(2^n)
def subsets_backtrack_for(nums: List[int]) -> List[List[int]]:
    def helper(pivot: int, path: List[int]):
        result.append(path[:])
        for i in range(pivot, len(nums)):
            path.append(nums[i])
            helper(i + 1, path)
            path.pop()

    result = []
    helper(0, [])
    return result


# Approach 3: Backtracking (Choose/Don't Choose)
# TC: O(2^n), SC: O(2^n)
def subsets_backtrack_binary(nums: List[int]) -> List[List[int]]:
    def helper(i: int, path: List[int]):
        if i == len(nums):
            result.append(path[:])
            return
        helper(i + 1, path)
        path.append(nums[i])
        helper(i + 1, path)
        path.pop()

    result = []
    helper(0, [])
    return result


# Input and output
nums = [1, 2, 3]

print("Iterative:", subsets_iterative(nums))
print("Backtracking (for loop):", subsets_backtrack_for(nums))
print("Backtracking (choose/don’t choose):", subsets_backtrack_binary(nums))
