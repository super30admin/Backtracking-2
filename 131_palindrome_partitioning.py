'''

## Problem 131: Palindrome partitioning

## Author: Neha Doiphode
## Date:   08-03-2022

## Description:
    Given a string s, partition s such that every substring of the partition is a palindrome.
    Return all possible palindrome partitioning of s.

    A palindrome string is a string that reads the same backward as forward.

## Examples:
    Example 1:
        Input: s = "aab"
        Output: [["a","a","b"],["aa","b"]]

    Example 2:
        Input: s = "a"
        Output: [["a"]]


## Constraints:
    1 <= s.length <= 16
    s contains only lowercase English letters.

## Time complexity : O(2^l * l), where l is length of the string.
                                 Exponential for the recursive children/possibilities/substrings per step.
                                 Addtional "l" for to check if the substring is palindrome or not.

## Space complexity: O(l), Space will be used to store the recursion stack.
                            Maximum depth of each recursive call stack is l for an input string of length l.
'''


from typing import List, Optional


def get_input():
    print("Enter the string: ", end = "")
    string = input()
    print()
    return string

class Solution:
    result = []
    def forloop_recursion(self, s: str, index: int, combination: List[str]) -> None:

        if index == len(s):
            self.result.append(list(combination))
            return

        # logic
        for i in range(index, len(s)):
            # Check if substring is a palindrome
            # Example: ["aa"],
            # remaining "ba" --> index = "b", i = "a"
            substr = s[index: i+1]
            if substr == substr[::-1]:
                combination.append(substr)
                self.forloop_recursion(s, i + 1, combination)
                combination.pop()

    def partition_forloop_recursion(self, s: str) -> List[List[str]]:
        """
                        aaba
            index   i
        1. ["a"], "aba"         ------> 8. ["a", "aba"] --> Add to result ----->   9. ["aa"], "ba"    ------->["aab"], "a" Not a valid palindrome ------->["aaba"] Not a valid palindrome
        2. ["a", "a"], "ba"     ------> 7. ["a", "ab"] Not a valid palindrome      10.["aa", "b"], "a" ------>["aa", "ba"] Not a valid palindrome
        3. ["a", "a", "b"], "a" ------> 6. ["a", "a", "ba"] Not a valid palindrome 11.["aa", "b", "a"]-------> Add to result
        4. ["a", "a", "b", "a"]-------> 5. Add to result

        """
        if len(s) == 0:
            return s

        self.result = []
        index = 0
        combination = []
        self.forloop_recursion(s, index, combination)
        return self.result

    def forloop_backtracking(self, s: str, index: int, combination: List[str]) -> None:

        if index == len(s):
            self.result.append(combination)
            return

        # logic
        for i in range(index, len(s)):
            # Check if substring is a palindrome
            # Example: ["aa"],
            # remaining "ba" --> index = "b", i = "a"
            substr = s[index: i+1]
            if substr == substr[::-1]:
                new_l = list(combination)
                new_l.append(substr)
                self.forloop_backtracking(s, i + 1, new_l)

    def partition_forloop_backtracking(self, s: str) -> List[List[str]]:
        if len(s) == 0:
            return s

        self.result = []
        index = 0
        combination = []
        self.forloop_backtracking(s, index, combination)
        return self.result


    def forloop_backtracking_without_index(self, s: str, combination: List[str]) -> None:

        if len(s) == 0:
            self.result.append(list(combination))
            return

        # logic
        for i in range(len(s)):
            # Check if substring is a palindrome
            # Example: ["aa"],
            # remaining "ba" --> index = "b", i = "a"
            substr = s[0: i+1]
            if substr == substr[::-1]:
                combination.append(substr)
                self.forloop_backtracking_without_index(s[i+1:], combination)
                combination.pop()

    def partition_forloop_backtracking_without_index(self, s: str) -> List[List[str]]:
        if len(s) == 0:
            return s

        self.result = []
        index = 0
        combination = []
        self.forloop_backtracking_without_index(s, combination)
        return self.result


# Driver code
solution = Solution()
string = get_input()
print(f"Input string: {string}")
print(f"Approach 1: For loop recursion   : Output palidrome partitioning of the input string: {solution.partition_forloop_recursion(string)}")
print(f"Approach 2: For loop backtracking: Output palidrome partitioning of the input string: {solution.partition_forloop_backtracking(string)}")
print(f"Approach 3: For loop backtracking without additional index: Output palidrome partitioning of the input string: {solution.partition_forloop_backtracking_without_index(string)}")
