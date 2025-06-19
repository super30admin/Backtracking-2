# Time Complexity: Exponential - O(n*2^n) where O(n) for the palindrome check and 2^n combinations for every character
# Space Complexity: O(n) for the recursion stack 
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.helper(s,0,0,[])
        return self.result

    def helper(self, s, pivot, idx, path):
        # Base
        if idx == len(s):
            if pivot == len(s):
                self.result.append(list(path))
            return
        # Logic
        # 0 Case
        self.helper(s, pivot, idx+1, path)

        # 1 Case
        sub = s[pivot:idx+1]
        if self.isPalindrome(sub):
            # Action
            path.append(sub)
            # Recurse
            self.helper(s, idx+1, idx+1, path)
            # Backtrack
            path.pop()

    def isPalindrome(self, s):
        start, end = 0, len(s) -1
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True