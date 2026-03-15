#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 78: Subsets
    Link: https://leetcode.com/problems/subsets/

    Problem:
    Given an integer array nums of unique elements, return all possible subsets
    (the power set). The solution set must not contain duplicate subsets.

    Approach:
    Backtracking. At each recursive call, the current path represents a valid subset
    and is added to results immediately (including the empty set). Then iterate from
    pivot onwards to avoid duplicate/reordered subsets, appending each element,
    recursing, and backtracking.

    1️⃣ Append a copy of path to results at every call (captures all subset sizes).
    2️⃣ Iterate i from pivot to end; append nums[i], recurse with pivot = i+1, pop.

    // Time Complexity : O(n * 2^n)
        2^n subsets, each taking up to O(n) to copy into results.
    // Space Complexity : O(n)
        Recursive call stack and path are at most O(n) deep.

"""

from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []

        def helper(nums, pivot, path):
            self.res.append(list(path))

            for i in range(pivot, len(nums)):
                path.append(nums[i])
                helper(nums, i + 1, path)
                path.pop()

        helper(nums, 0, [])
        return self.res
