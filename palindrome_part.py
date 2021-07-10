# Time Complexity: O(n. 2^n)
# Space Complexity: O(n)

class Solution(object):
    #     Output list
    result = []

    #    check if start and end index of a string is palindrome. in that range or not
    def isPalindrome(self, s, start, end):
        while start < end:
            if s[start] == s[end]:
                start += 1
                end -= 1
            else:
                return False
        return True

    # Backtrack function where iterate over the string and check
    # if with the  current index given substring is palindrome or not
    # If yes then add that substring to the path and recursively call the same function for next index
    # and update the path by popping last element to backtrack
    # when the index reached the end of the string add the current path to the output list
    def backtrack(self, s, index, path):
        #         Base
        if index >= len(s):
            self.result.append(list(path))

        #         Logic
        for i in range(index, len(s)):
            if self.isPalindrome(s, index, i):
                path.append(s[index:i + 1])
                self.backtrack(s, i + 1, path)
                path.pop()

    def partition(self, s):
        self.result = []

        self.backtrack(s, 0, [])

        return self.result

        """
        :type s: str
        :rtype: List[List[str]]
        """
