# Time Complexity - 
# Space Complexity - 
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        result = []
        self.backtrack(s, 0, result, [])
        return result
    def isPalindrome(self, s):
        left = 0
        right = len(s)-1
        while left <= right:
            if s[left] != s[right]:
                return False
            else:
                left += 1
                right -= 1
        return True
    def backtrack(self, s, index, result, currentList):
        if index >= len(s):
            result.append(list(currentList))
        for i in range(index,len(s)):
            current = s[index:i+1]
            if self.isPalindrome(current):
                currentList.append(current)
                self.backtrack(s,i+1, result, currentList)
                currentList.pop(-1)
            
                
        
        