"""
TC: O(N * 2^N) {where N is the number of elements in `nums`. There are `2^N` possible subsets, and for each one, it takes `O(N)` time to copy it to the result list.}
SC: O(N * 2^N) {The space is determined by the output array, which stores `2^N` subsets, each with a potential length of `N`.}

Approach:

This problem is solved using a **backtracking** algorithm. The core idea is to systematically generate all possible subsets by exploring a decision tree where at each step, we consider adding the current element to our path. The recursive `backtrack` function takes a `pivot` index to ensure we only consider elements in increasing order, which prevents duplicate subsets.

In each recursive call, the current `arr` (representing a subset) is added to our result list. We then iterate from the `pivot` index to the end of the input `nums` array. For each element, we add it to the `arr` and make a recursive call with the next index (`i+1`). After the call returns, we **backtrack** by removing the last element added. This process continues until all possible subsets have been generated.

The problem ran successfully on LeetCode.
"""
from typing import List
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        def backtrack(pivot, arr):
            #base case
           
            res.append(arr[:])


            #logic

            for i in range(pivot, len(nums)):
                arr.append(nums[i])
                backtrack(i+1, arr)
                arr.pop()    
        

        res = []
        backtrack(pivot=0,arr=[])
        return res