class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.final=[]
        def findPalindrome(c):
            l=0
            h=len(c)-1
            if l==h:
                return True
            while(l<h):
                if c[l]!=c[h]:
                    return False
                l+=1
                h-=1
            return True
        def palindrome(index,cur):
            if index==len(s):
                self.final.append([v for v in cur])
                return
            for i in range(index,len(s)):
                l1=i-index
                
                if findPalindrome(s[index:i+1]):
                    cur.append(s[index:i+1])
                    palindrome(i+1,cur)
                    cur.pop()
                
        palindrome(0,[])
        return self.final
        #Time Complexity :o(n*2^n)
        #space(n)
