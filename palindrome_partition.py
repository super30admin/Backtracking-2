# O(N * 2^N) TIME AND O(N) SPACE WHERE N IS LEN(S)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        return self.getPalindromes(s,0,[],[])
    
    def getPalindromes(self,s,index,path,output):
        if index == len(s):
            output.append(path[:])
            return output
        for i in range(index,len(s)):
            current_str = s[index:i+1]
            if not self.isPalindrome(current_str):
                continue
            path.append(current_str)
            self.getPalindromes(s,i+1,path,output)
            path.pop()
        return output
    
    def isPalindrome(self,s):
        left = 0
        right = len(s)-1
        while left <= right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True
        