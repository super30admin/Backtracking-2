# Time Complexity: O(n * 2**n) n for creating copy of paths and 2**n for the recursion
# n is the length of string
# Space Complexity: O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # global result
        # result = []

        # Choose / Don't choose recursion (0-1 recursion)

        # def recursion(idx, path):
        #     global result
        #     # Base Case
        #     if idx >= len(nums):
        #         result.append(path.copy())
        #         return
        #     # Logic
        #     # Dont choose
        #     recursion(idx+1, path)

        #     # Choose
        #     path.append(nums[idx])
        #     recursion(idx+1, path)

        #     # Backtrack
        #     path.pop()

        # recursion(0, [])
        # return result

        # global result
        # result = []

        # For loop recursion

        # def recursion(idx, path):
        #     global result
        #     # Base Case
        #     result.append(path.copy())
        #     # Logic
        #     for i in range(idx, len(nums)):
        #         # Action
        #         path.append(nums[i])
        #         # Recurse
        #         recursion(i+1, path)
        #         # Backtrack
        #         path.pop()

        # recursion(0, [])
        # return result

        # Non-recursion approach
        result = [[]]
        path = []
        for i in range(len(nums)):
            for j in range(len(result)):
                path = result[j].copy()
                path.append(nums[i])
                result.append(path.copy())
        return result

