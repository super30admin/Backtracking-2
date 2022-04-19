
// Time Complexity : o(2^(n))*n where n is length of string 
//         as at every step we have two choices to choose or not
// Space Complexity : o(n)) length of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution:
    def palindrome(self,s):
        return s == s[::-1]
                   
        
    def partition(self, s: str) -> List[List[str]]:
        self.result=[]
        self.partition_p(s,0,[])
        return self.result
        
    def partition_p(self,s,index,parts):
        
        #base
        if index ==len(s):
            val=parts.copy()
            self.result.append(val)
        
        
        #recurse
        for i in range(index, len(s)):  
            sub_string=s[index:i+1]
            if self.palindrome(sub_string):
                parts.append(sub_string)
                self.partition_p(s,i+1,parts)
                parts.pop()
            
            
                
            
            