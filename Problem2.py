class Solution(object):
    def ispalindrome(self,s):
        low,high = 0,len(s)-1
        while low < high:
            if s[low]!= s[high]:
                return False
            low = low + 1
            high = high - 1
        return True
    
    def util(self, s, start, curr):
        
        if start >= len(s):
            self.res.append(list(curr))
            
        for i in range(start,len(s)):
            if self.ispalindrome(s[start:i+1]):
                curr.append(s[start:i+1])
                self.util(s,i+1,curr)
                curr.pop()
                
            
    def partition(self, s):
        start = 0
        curr = []
        self.res  = []
        
        self.util(s,start,curr)
        return self.res
        """
        :type s: str
        :rtype: List[List[str]]
        """
        