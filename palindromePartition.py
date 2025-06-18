"""
Check for every prefix of the string
If it's a palindrome, recurse on remaining substring
Backtrack and explore other valid splits
"""
"""
Time Complexity: O(2^ × n) – All possible partitions × cost of palindrome checking
Space Complexity: O(n) – Max recursion depth
"""

from typing import List

class palindromePartition:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def is_palindrome(sub):
            return sub == sub[::-1]

        def backtrack(start, path):
            if start == len(s):
                result.append(list(path))
                return

            for end in range(start + 1, len(s) + 1):
                prefix = s[start:end]
                if is_palindrome(prefix):
                    path.append(prefix)
                    backtrack(end, path)
                    path.pop()

        backtrack(0, [])
        return result

if __name__ == "__main__":
    obj = palindromePartition()
    print(obj.partition("aab"))


