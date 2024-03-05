'''
TC: O(n*2^n) = n is all the letters in string
SC: O(n*2^n)
'''
from typing import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []

        def isPalindrome(word):
            i,j = 0, len(word)-1
            while i<=j:
                if word[i]!=word[j]:
                    return False
                i+=1
                j-=1
            return True
        
        def backtrack(start, temp):
            #Base
            if start==len(s):
                self.res.append(list(temp))

            #Logic
            for i in range(start, len(s)):
                word = s[start:i+1]
                if isPalindrome(word):
                    temp.append(word)
                    backtrack(i+1, temp)
                    temp.pop()

        backtrack(0,[])
        return self.res
s = Solution()
print(s.partition("aab"))
print(s.partition("aaba"))
print(s.partition("a"))
print(s.partition("abcd"))