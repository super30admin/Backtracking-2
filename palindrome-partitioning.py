# The partition function generates all possible palindrome partitions of a string by checking each prefix and 
# recursively partitioning the rest of the string. It adds valid partitions (where each substring is a palindrome) to the result.

# Time Complexity: O(2^n * n), where n is the length of the string. In the worst case, we check every possible partition (2^n), 
# and for each partition, we check if a substring is a palindrome (which takes O(n) time).
# Space Complexity: O(n), due to the recursion stack used for partitioning and storing the results.

class Solution:
    def is_palindrome(self, s: str) -> bool:
            return s == s[::-1]
    def partition(self, s: str) -> List[List[str]]:
        if not s:
            return [[]]
        result = []
        for i in range(1, len(s) + 1):
            if self.is_palindrome(s[:i]):
                for rest in self.partition(s[i:]):
                    result.append([s[:i]] + rest)
        return result