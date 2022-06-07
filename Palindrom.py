'''
time complexity: O(exponential)
space complexity: O(len of string)
'''
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        global results
        
        results = []
        
        self.helper(s,0,[])
        return results
        
    def helper(self,s,idx,ls):
        #base condition
        global results
        if(idx == len(s)):
            results.append(list(ls))
            return
        #logic
        for i in range(idx,len(s)):
                subst = s[idx:i+1]
                if(self.isPalindrome(subst)):
                    ls.append(subst)
                    self.helper(s,i+1,ls)
                    ls.pop()

    def isPalindrome(self,st):
        i=0
        j=len(st)-1
        while(i<=j):
            if(st[i]!=st[j]):
                return False
            i+=1
            j-=1
            
        return True