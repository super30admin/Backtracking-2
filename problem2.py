#Time O(2^n*n), space O(n)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res=[]
        
        self.helper(s,0,[],res)
        return res
    
    
    def helper(self,s,index,cur,res):
      #If index reaches the end of s return res  
        if index==len(s):
            res.append(cur.copy())
            return
       
        for i in range(index,len(s)):
         #checking palindrome   
            if s[index:i+1]==s[index:i+1][::-1]:
                cur.append(s[index:i+1])
                self.helper(s,i+1,cur,res)             
                cur.pop()
                print(cur)
