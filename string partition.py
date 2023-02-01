# Time Complexity :O(n*2^n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No



import copy
class Solution(object):
    def __init__(self):
        self.result=[]
    
    def partition(self, s):
        self.rec(0,0,[],s)
        return(self.result)
    

    def rec(self,i,p,path,s):
        #Base
        if(p==len(s) and i==len(s)):
            self.result.append(copy.deepcopy(path))
            
        if(i==len(s)):
            return
       
        self.rec(i+1,p,path,s)
        if(self.ispalindrome(s[p:i+1])):
            self.rec(i+1,i+1,path+[s[p:i+1]],s)
        else:
            return
        
    
    def ispalindrome(self,s):
        if(len(s)==1):
            return True
        else:
            l=0
            r=len(s)-1
            while(l<r):
                if(s[l]!=s[r]):
                    return False
                l+=1
                r-=1
            return True
