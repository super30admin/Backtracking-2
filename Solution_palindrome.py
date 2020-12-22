class Solution_palindrome:
#spc-o(n) and time n^n
    def partition(self, s: str) -> List[List[str]]:
        self.result=[]
    
        self.helper(s, 0, [])
        
        return self.result 
    
    def helper(self, s, index, temp):
        if index==len(s):
            self.result.append(list(temp))
            return 

        for i in range(index, len(s)):
            if self.isPalindrome(s[index:i+1]):
                # temp2=list(temp)
                temp.append(s[index:i+1])
                self.helper(s, i+1, temp)
                temp.pop()
                
    def isPalindrome (self, s):
        if len(s)==1:
            return True
        l=0
        r=len(s)

        for i in range((l+r)//2):
            if s[i]!=s[len(s)-i-1]:
                return False

        return True
