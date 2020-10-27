# O(N * POW(2,N)) TIME AND O(N) SPACE
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        palindromes = []
        self.findPalindromes(s,0,[],palindromes)
        return palindromes
    
    def findPalindromes(self,s,start,current_palindrome,palindromes):
        if start >= len(s):
            palindromes.append(current_palindrome[:])
            return
        
        for i in range(start,len(s)):
            substr = s[start:i+1]
            if self.isPalindrome(substr):
                current_palindrome.append(substr)
                self.findPalindromes(s, i + 1, current_palindrome,palindromes)
                current_palindrome.pop()
    
    def isPalindrome(self,string):
        left = 0
        right = len(string) - 1
        while left <= right:
            if string[left] != string[right]:
                return False
            left += 1
            right -= 1
        return True
        