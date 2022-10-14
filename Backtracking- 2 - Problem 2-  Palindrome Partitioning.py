"""
FAANMG Problem #74 {Medium} 


131. Palindrome Partitioning 

Time complexity : O(N * 2^N)
Space complexity : O(H)


Did this code successfully run on Leetcode : Yes

For loop based Recursive Solution : 
    For loop based recursion, by taking all possible substring.

@name: Rahul Govindkumar_RN27JUL2022
"""      


class Solution:
    
    def ispalindrome(self,s):
        start =0
        
        end = len(s)-1
        
        while(start<end):
            if s[start] != s[end]:
                return False
            
            start +=1
            end -=1
        return True           
        
        
    
    def helper(self,string, idx, path):
        
        #base
        if idx==len(string):
            self.result.append(list(path))
            return
        
        #logic
        
        for i in range(idx,len(string)):
            
            sub_str=string[idx:i+1]
            
            # check if the substring is a palindrome
            if self.ispalindrome(sub_str):
                path.append(sub_str)
                
                self.helper(string,i+1, path)
                
                path.pop()
        
    
    def partition(self, s: str) -> List[List[str]]:
        
        self.result=[]
        
        self.helper(s,0,[])
        
        return self.result
        
    
    
"""
FAANMG Problem #74 {Medium} 


131. Palindrome Partitioning 

Time complexity : O(N * 2^N)
Space complexity : O(H)


Did this code successfully run on Leetcode : Yes

For loop based Recursive Solution :  Backtracking
 Without taking the pivot and fixing it at 0 index
 
 
@name: Rahul Govindkumar_RN27JUL2022
"""  

class Solution:
    
    def ispalindrome(self,s):
        start =0
        
        end = len(s)-1
        
        while(start<end):
            if s[start] != s[end]:
                return False
            
            start +=1
            end -=1
        return True           
        
        
    
    def helper(self,string,  path):
        
        #base
        if len(string)==0:
            self.result.append(list(path))
            return
        
        #logic
        
        for i in range(len(string)):
            
            sub_str=string[0:i+1]
            
            if self.ispalindrome(sub_str):
                path.append(sub_str)
                
                self.helper(string[i+1:], path)
                
                path.pop()
        
    
    def partition(self, s: str) -> List[List[str]]:
        
        self.result=[]
        
        self.helper(s,[])
        
        return self.result
        


"""
FAANMG Problem #74 {Medium} 


131. Palindrome Partitioning 

Time complexity : O(N * 2^N)
Space complexity : O(H)


Did this code successfully run on Leetcode : Yes

For loop based Recursive Solution : 
    temp path

@name: Rahul Govindkumar_RN27JUL2022
"""  

class Solution:
    
    def ispalindrome(self,s):
        start =0
        
        end = len(s)-1
        
        while(start<end):
            if s[start] != s[end]:
                return False
            
            start +=1
            end -=1
        return True           
        
        
    
    def helper(self,string, idx, path):
        
        #base
        if idx==len(string):
            self.result.append(list(path))
            return
        
        #logic
        
        for i in range(idx,len(string)):
            
            sub_str=string[idx:i+1]
            
            if self.ispalindrome(sub_str):
                temp=list(path)
                temp.append(sub_str)
                
                self.helper(string,i+1, temp)
                
                # path.pop()
        
    
    def partition(self, s: str) -> List[List[str]]:
        
        self.result=[]
        
        self.helper(s,0,[])
        
        return self.result
        

"""
FAANMG Problem #74 {Medium} 


131. Palindrome Partitioning 

Time complexity : O(N * 2^N)
Space complexity : O(H)


Did this code successfully run on Leetcode : Yes

0 1 Recursion

@name: Rahul Govindkumar_RN27JUL2022
"""  

class Solution:
    
    def ispalindrome(self,s):
        start =0
        
        end = len(s)-1
        
        while(start<end):
            if s[start] != s[end]:
                return False
            
            start +=1
            end -=1
        return True           
        
        
    
    def helper(self,string, idx, i, path):
        
        #base
        if idx==len(string):
            self.result.append(list(path))
            return
        
        if i ==len(string):
            return
        
        #logic
        #dont choose
        self.helper(string, idx, i+1, path)
        
        
        #choose
        
        sub_str= string[idx:i+1]
        
        if self.ispalindrome(sub_str):
            path.append(sub_str)
            
            self.helper(string, i+1, i+1, path)
            path.pop()
            
        
        
    
    def partition(self, s: str) -> List[List[str]]:
        
        self.result=[]
        
        self.helper(s,0,0,[])
        
        return self.result
        