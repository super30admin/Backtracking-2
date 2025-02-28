class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []  # Stores the final partitions
        path = []  # Temporary list to store the current partition

        def is_palindrome(sub: str) -> bool:
            return sub == sub[::-1]

        def backtrack(start: int):
            if start == len(s):
                res.append(path[:])  # Add a copy of the path to results
                return

            for end in range(start, len(s)):
                substring = s[start:end+1]
                if is_palindrome(substring):
                    path.append(substring)  # Choose
                    backtrack(end + 1)  # Explore
                    path.pop()  # Unchoose (backtrack)

        backtrack(0)
        return res