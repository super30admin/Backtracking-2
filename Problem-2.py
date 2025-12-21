# Time Complexity: O(n * 2^n) in the worst case, n = length of the string
# Space Complexity: O(n) for recursion stack + O(total partitions) for result
# 1. Use DFS/backtracking to explore all possible partitions of the string.
# 2. For each substring, check if it is a palindrome before adding to the current path.
# 3. Add the current path to the result when the end of the string is reached and backtrack.

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.helper(s,[],0)
        return self.result
    def helper(self,s,path,pivot):
        if pivot == len(s):
            self.result.append(list(path))
            return
        for i in range(pivot, len(s)):
            curr = s[pivot:i+1]
            if self.isPalindrome(curr):
                path.append(curr)
                self.helper(s,path,i+1)
                path.pop()
    def isPalindrome(self,curr):
        i = 0
        j = len(curr)-1
        while i < j:
            if curr[i] != curr[j]:
                return False
            i += 1
            j -= 1
        return True

