# Time Complexity => O(N.x^N) Exponential
# Space Complexity => O(N)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        if(s == None or len(s) == 0):
            return self.result
        self.helper(s,0,[])
        return self.result
    
    def helper(self,s,index,path):
        if(index == len(s)):
            self.result.append(path.copy())
            return 
        
        for i in range(index,len(s)):
            if(self.ispalindrome(s,index,i)):
                path.append(s[index:i+1])
                self.helper(s,i+1,path)
                path.pop()
        
    def ispalindrome(self, s,left,right):
        while(left<right):
            if(s[left] != s[right]):
                return False
            left += 1
            right -= 1
            
        return True
            