'''
Backtracking-2

Problem1

Subsets (https://leetcode.com/problems/subsets/)
'''

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]: # type: ignore
        if nums == None or len(nums) == 0:
            return []

        self.result = []
        self.recurse(nums, 0, [])
        return self.result

    def recurse(self, nums:List[int], idx:int, path:List[int]) -> None: # type: ignore
        #base
        if idx == len(nums):
            self.result.append([num for num in path])
            return

        #logic
        #case 0
        self.recurse(nums, idx+1, path)

        #case1
        path.append(nums[idx])
        self.recurse(nums, idx+1, path)   
        path.pop()  