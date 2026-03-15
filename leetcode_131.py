#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 131: Palindrome Partitioning
    Link: https://leetcode.com/problems/palindrome-partitioning/

    Problem:
    Given a string s, partition s such that every substring of the partition is a
    palindrome. Return all possible palindrome partitioning of s.

    Approach:
    Backtracking. At each step, try every substring s[pivot:i+1]. If it is a
    palindrome, add it to path and recurse from i+1. When pivot reaches the end
    of the string, a complete valid partition is found — append a deep copy to results.

    1️⃣ Base case: pivot == len(s) → append deep copy of path to results.
    2️⃣ Iterate i from pivot to end; extract s[pivot:i+1].
    3️⃣ If substring is a palindrome, append to path, recurse with pivot = i+1, pop.
    4️⃣ palindrome() uses two pointers to check in O(k) time.

    // Time Complexity : O(n * 2^n)
        At most 2^n partitions; palindrome check is O(n) per substring.
    // Space Complexity : O(n)
        Recursive call stack and path are at most O(n) deep.

"""

import copy
from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []

        def helper(s, pivot, path):
            if pivot == len(s):
                self.result.append(copy.deepcopy(path))
                return

            for i in range(pivot, len(s)):
                subString = s[pivot:i + 1]
                if palindrome(subString):
                    path.append(subString)
                    helper(s, i + 1, path)
                    path.pop(-1)

        def palindrome(s):
            l = 0
            r = len(s) - 1
            while l < r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            return True

        helper(s, 0, [])
        return self.result
