'''
78 Subsets
https://leetcode.com/problems/subsets/description/

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.


Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

Solution:
1. Recursion:
case 0: don't pick the number at the ith index (array[i]), and do a recursion on the next number at index i + 1 (array[i+1])

case 1: pick the number at the ith index (array[i]), and do a recursion on the NEXT number (array[i+1]) since repetitions of a number are NOT allowed

Time: O(2^N), Space: O(N), N = number of ints in nums array

'''

def subsets_of_ints(nums):
    def recurse(s,i,path):
        if i >= N:
            result.append(path.copy())
            return

        # case 0: dont pick s[i]
        recurse(s,i+1,path)

        # case 1: pick s[i]
        path.append(s[i])
        recurse(s,i+1,path)
        path.pop()
        return

    if not nums:
        return nums
    N = len(nums)
    result = []
    path = []
    recurse(nums,0,path)
    return result

def run_subsets_of_ints():
    tests = [ ([1,2,3], [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]),
              ([0], [[], [0]]),
    ]
    for test in tests:
        nums, ans = test[0], test[1]
        subsets = subsets_of_ints(nums)
        print(f"\nnums = {nums}")
        print(f"Power set = {subsets}")
        print(f"Pass: {sorted(ans) == sorted(subsets)}")

run_subsets_of_ints()