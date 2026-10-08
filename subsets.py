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
1. 0/1 recursion w/ backtracking:
case 0:
    a) don't pick the number at the ith index (array[i]), and do a recursion on the next number at index i + 1 (array[i+1])

case 1:
    a) Action: append current number array[i] to the path.
    b) Recursion: pick the number at the ith index (array[i]), and do a recursion on the NEXT number (array[i+1]) since repetitions of a number are NOT allowed
    c) Backtracking: pop the path
Time: O(2^N), Space: O(N), N = number of ints in nums array
https://youtu.be/ufBY5XwfQM8?t=2895
https://youtu.be/kxA7lFkS0Eg?t=57

2. 0/1 recursion w/o backtracking:
But this is inefficient due to creation a new list at every recursion call.
Time: O(2^N), Space: O(N), N = number of ints in nums array
https://youtu.be/kxA7lFkS0Eg?t=660

3. for-loop recursion w/ backtracking:
Time: O(2^N), Space: O(N), N = number of ints in nums array
https://youtu.be/ufBY5XwfQM8?t=4050
https://youtu.be/kxA7lFkS0Eg?t=770

4. Non-recursive solution:
Time: O(2^N), Space: O(N), N = number of ints in nums array
https://youtu.be/kxA7lFkS0Eg?t=1431
(asked at Meta)
'''
def subsets_of_ints_1(nums):
    '''
    0/1 recursion w/ backtrack
    '''
    def recurse(nums, index, path):
        # base
        if index >= N:
            result.append(path.copy())
            return

        # logic
        # no choose
        recurse(nums, index+1, path)

        # choose
        path.append(nums[index])
        recurse(nums, index+1, path)
        path.pop()

        return

    if not nums:
        return nums
    N = len(nums)
    result = []
    path = []
    recurse(nums, 0, path)
    return result


def subsets_of_ints_2(nums):
    '''
    0/1 recursion no backtrack
    '''
    def recurse(nums, index, path):
        # base
        if index >= N:
            result.append(path.copy())
            return

        # logic
        # no choose
        recurse(nums, index+1, path)

        # choose
        li = path.copy()
        li.append(nums[index])
        recurse(nums, index+1, li)
        return

    if not nums:
        return nums
    N = len(nums)
    result = []
    path = []
    recurse(nums, 0, path)
    return result

def subsets_of_ints_3(nums):
    '''
    for-loop recursion
    '''
    def recurse(nums, pivot, path):
        # pitfall if I use the if statement below:
        # if nums = [1,2,3], then result = [1,2,3], [1,3], [2,3], [3].
        # Thus, result stores the path only when the last element (3) is included

        #if pivot >= N:
            # result.append(path.copy())

        # Thus,
        # 0/1 recursion:  if pivot >= N: result.append(path.copy())
        # for-loop recursion: result.append(path.copy()) (add path to result at every recursion call)
        result.append(path.copy())

        for j in range(pivot, N):
            path.append(nums[j])
            recurse(nums, j + 1, path)
            path.pop()
        return


    if not nums:
        return nums
    N = len(nums)
    result = []
    path = []
    recurse(nums, 0, path)
    return result

def subsets_of_int_4(nums):
    '''
    non-recursive solution
    '''
    result = [[]]
    for num in nums: # for lopp around nums
        size = len(result)
        for j in range(size): # for loop around the result array
            temp = result[j][:]
            temp.append(num)
            result.append(temp)

    return result


def run_tests():
    tests = [ ([1,2,3], [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]),
              ([0], [[], [0]]),
    ]
    for test in tests:
        nums, ans = test[0], test[1]
        print(f"\nnums = {nums}")
        for method in ['01-backtrack', '01-no-backtrack', 'for-loop-backtrack', 'non-recursive']:
            if method == '01-backtrack':
                subsets = subsets_of_ints_1(nums)
            if method == '01-no-backtrack':
                subsets = subsets_of_ints_2(nums)
            elif method == 'for-loop-backtrack':
                subsets = subsets_of_ints_3(nums)
            elif method == 'non-recursive':
                subsets = subsets_of_int_4(nums)
            print(f"{method}: Power set = {subsets}")
            passed = (sorted(ans) == sorted(subsets))
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()