'''
131 Palindrome Partioning
https://leetcode.com/problems/palindrome-partitioning/description/

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.

Solution:
1. Recursion:
case 0: don't partition after the number at the ith index (array[i]), and do a recursion on the next number at index i + 1 (array[i+1])

case 1: make a partition after the number at the ith index (array[i]), check if the last string is a palindrome. If yes, do a recursion on the NEXT number (array[i+1]). If no, return (discard the current partition)

Let N = number of characters in string s, K = average length of the palindromes
Time: O((2^N)*K), Space: O(N)

'''

def is_palindrome(s): # shortand for palindrome check: return (s == s[::-1])
    left = 0
    right = len(s) - 1
    while left < right:
        if s[left] != s[right]:
            return False
        left += 1
        right -= 1
    return True

def partition(s):
    def recurse(s, i, path, end_prev_string):
        # base
        if i == N:
            if is_palindrome(path[-1]):
                result.add(tuple(path.copy()))
            return

        # logic
        c = s[i]
        # case 0: don't partition after the curr character c
        if not end_prev_string:
             # If there was no partition after the last char of previous string, concat the current char c to the prev string
            path[-1] = path[-1] + c
            recurse(s, i+1, path, False)
            path[-1] = path[-1][:-1] # remove c
        else:
            # If there was a partition, the current char c is a new string (1-length palindrome)
            path.append(c)
            recurse(s, i+1, path, False)
            path.pop()


        # case 1: partition after the current char c
        if not end_prev_string:
            # If there was no partition after the last char of previous string, concat the current char c to the prev string
            path[-1] = path[-1] + c
            # since path[-1] has to be paritioned, we check if path[-1] is a valid palindrome. If yes, recurse using the next char. If not, remove c from path[-1]
            if is_palindrome(path[-1]):
                recurse(s, i+1, path, True)
            path[-1] = path[-1][:-1] # remove c
        else:
            # If there was a partition, the current char c is a new string (1-length palindrome)
            path.append(c)
            recurse(s, i+1, path, True)
            path.pop()

    if not s or len(s) == 1:
        return [[s]]

    N = len(s)
    result = set()
    path=[s[0]]
    recurse(s, 1, path, False)
    recurse(s, 1, path, True)
    return [list(k) for k in result]

def run_partition():
    tests = [("abaa",  [['a', 'b', 'a', 'a'], ['aba', 'a'], ['a', 'b', 'aa']]),
             ("aab",   [["a","a","b"],["aa","b"]]),
             ("abab",  [['a','b','a','b'], ['a', 'bab'], ['aba','b']]),
             ("abbab", [["a","b","b","a","b"],["a","b","bab"],["a","bb","a","b"],["abba","b"]]),
    ]
    for test in tests:
        s, ans = test[0], test[1]
        result = partition(s)
        print(f"\nString = {s}")
        print(f"Partitions = {result}")
        print(f"Pass: {sorted(ans) == sorted(result)}")

run_partition()