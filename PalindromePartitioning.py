"""
Rasika Sasturkar
Time Complexity: O(n*(2)^n), n is length of string.
Space Complexity: O(n)
"""


def check_palindrome(s):
    return s == s[::-1]


class Solution:
    """
    The logic is to create a substring from pivot to i using for-loop
    recursion. if the substring is palindrome we add it in the path and
    continue the recursion else we return.
    """
    result = []

    def partition(self, s: str):
        self.result = []

        # null case
        if s is None:
            return self.result

        self.helper(s, 0, [])
        return self.result

    def helper(self, s, pivot, path):
        # base case
        if pivot == len(s):
            self.result.append(path.copy())
            return
        # logic
        for i in range(pivot, len(s)):
            subs = s[pivot:(i + 1)]
            if check_palindrome(subs):
                path.append(subs)  # action
                self.helper(s, i + 1, path)  # recurse
                path.pop()  # backtrack


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    s = Solution()
    print(s.partition(s="aab"))  # returns [['a', 'a', 'b'], ['aa', 'b']]
    print(s.partition(s="a"))  # returns [['a']]
    print(s.partition(s="aaba"))  # return [['a', 'a', 'b', 'a'], ['a', 'aba'], ['aa', 'b', 'a']]


if __name__ == "__main__":
    main()
