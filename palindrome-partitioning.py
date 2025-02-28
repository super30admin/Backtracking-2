#Time O(n*2^n), n= length of s, choose/not choose and check palindrome O(n)
# Space O(n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        self.checkPartition(s, 0, [], result)
        return result

    def isPalindrome(self, s: str) -> bool:
        n = len(s)
        i = 0 
        j = n-1
        while i <= j:
            if s[i] != s[j]: return False
            i += 1
            j -= 1
        return True

    def checkPartition(self, s: str, pivot: int, path: List[str], result: List[List[str]]) -> None:
        if pivot >= len(s): 
            result.append(path.copy())
            return

        for i in range(pivot, len(s)):
            substring = s[pivot: i+1]
            if self.isPalindrome(substring):
                path.append(substring)
                self.checkPartition(s, i+1, path, result)
                path.pop()

# Time O(n*2^n)
# Space O(n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        self.checkPartition(s, 0, 0, [], result)
        return result

    def isPalindrome(self, s: str) -> bool:
        n = len(s)
        i = 0 
        j = n-1
        while i <= j:
            if s[i] != s[j]: return False
            i += 1
            j -= 1
        return True

    def checkPartition(self, s: str, start: int, end:int, path: List[str], result: List[List[str]]) -> None:

        # Base
        if end >= len(s):
            if start >= len(s): 
                result.append(path.copy())
            return

        # Not choose
        self.checkPartition(s, start, end+1, path, result)

        # Choose to patition at index i
        substring = s[start: end+1]
        if self.isPalindrome(substring):
            path.append(substring)
            self.checkPartition(s, end+1, end+1, path, result)
            path.pop()
        
        


    