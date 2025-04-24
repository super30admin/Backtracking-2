# - This is a backtracking solution that explores all possible partitions and checks each substring for being a palindrome.
# - At each index, we expand the substring and proceed recursively if it's a palindrome.
# - Time Complexity: O(2^n * n), Space Complexity: O(n) for recursion stack and O(n) per partition (where n is length of string).

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def is_palindrome(sub: str) -> bool:
            return sub == sub[::-1]

        def backtrack(start: int, path: List[str]):
            if start == len(s):
                result.append(path[:])
                return

            for end in range(start + 1, len(s) + 1):
                prefix = s[start:end]
                if is_palindrome(prefix):
                    path.append(prefix)
                    backtrack(end, path)
                    path.pop()

        backtrack(0, [])
        return result
