class Solution(object):
    def partition(self, s):
        """
        Time complexity - 2^n, n --> length of the input string
        Space complexity - 2^n
        :type s: str
        :rtype: List[List[str]]
        """
        def is_palindrome(string):
            return string == string[::-1]

        def backtrack(start, path):
            # Base case: Reached the end of the string, add the path to the result.
            if start == len(s):
                result.append(path[:])
                return

            for end in range(start + 1, len(s) + 1):
                sub_string = s[start:end]
                # If the substring is a palindrome, explore further.
                if is_palindrome(sub_string):
                    # Add the current palindrome to the path.
                    path.append(sub_string)
                    # Recursively explore the rest of the string.
                    backtrack(end, path)
                    path.pop()  # Backtrack and remove the current palindrome.

        result = []  # List to store the final partitioned palindromes.
        # Start the backtracking from the beginning of the string.
        backtrack(0, [])
        return result
