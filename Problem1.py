#Time complexity - O(2^n)
#Space Complexity - O(n)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        def explore(index, arr):
            nonlocal result 
            result.append(arr.copy())

            if index == len(nums):
                return

            for i in range(index, len(nums)):
                arr.append(nums[i])
                explore(i + 1, arr)
                arr.pop()
        
        explore(0, [])
        return result 
            