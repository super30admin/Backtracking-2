#timecomplexity=
#spacecomplexity
#how i can find the time complexity in this ?

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result=[]
        if s=="": return self.result
        # word empty index
        self.helper(s,[],0)
        return self.result
                
            
    def helper(self,s,templist,index):    
        #base
        if index==len(s):
            temp=templist[:]
            self.result.append(temp)
            return
        #logic
        for i in range(index,len(s)):
            #action check for palindrome
            if self.palindrome(s[index:i+1]):
                #adding into templist As partition part
                templist.append(s[index:i+1])
                self.helper(s,templist,i+1)
                templist.pop()
            
        
        
        
    def palindrome(self,s):
            return s==s[::-1]
                
        