'''
Problem2

Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)
'''

class Solution:
    def partition(self, s: str) -> List[List[str]]: # type: ignore
        if s == None or len(s) == 0:
            return []
        self.result = []
        self.recurse(s, 0, [])
        return self.result

    def recurse(self, s:str, pivot:int, path:List[str]) -> None: # type: ignore
        #base
        if pivot == len(s):
            self.result.append(path)
            return 

        #logic
        for i in range(pivot, len(s)):
            sub = s[pivot: i+1]
            if self.isPalindrome(sub):
                newList = [num for num in path]
                newList.append(sub)
                self.recurse(s, i+1, newList)        

    def isPalindrome(self, s:str) -> bool:
        l = 0
        r = len(s) - 1
        while l <= r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True                    