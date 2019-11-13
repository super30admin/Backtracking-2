# Leet code : Palindrom parttioning - 131 - https://leetcode.com/problems/palindrome-partitioning/
# Time complexity - O(2^N)
# Approach : If the intial string is palindrome, we are calling the rest of the string.And also the entire path should be palindrome then only we append to the result. We will be calling backtracking function only when the parent is palindrome. 


class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        res=[]
        path=[]
        start=0
        if not s: return res
        self.backtrack(s,start,path,res)
        return res
        
    def backtrack(self,s,start,path,res):
        #base case
        
        if start==len(s):
            res.append(path[:])
        
        
        #logic
        for i in range(start,len(s)):
            print("before:", start,i)
            if self.palindrome(s,start,i):
                print("after:",start,i)
                if start==i: # at first index when individual elements are present [a],[b],[c]
                    path.append(s[i])
                else:
                    path.append(s[start:i+1]) #all possible combintions of string 
                self.backtrack(s,i+1,path,res)
                path.pop(-1)
                
        
   
    def palindrome(self,string,l,r):
        if l==r:
            return True
        while (l<r):
            if string[l]!=string[r]:
                return False
            l=l+1
            r=r-1
        return True
    
    
    
#using Global Variables.
class Solution(object):
    def partition(self, s):
        res=None
        path=None
        """
        :type s: str
        :rtype: List[List[str]]
        """
        Solution.res=[]
        Solution.path=[]
        start=0
        if not s: return res
        self.backtrack(s,start)
        return Solution.res
        
    def backtrack(self,s,start):
        #base case
        
        if start==len(s):
            Solution.res.append(Solution.path[:])
        
        
        #logic
        for i in range(start,len(s)):
            print("before:", start,i)
            if self.palindrome(s,start,i):
                print("after:",start,i)
                if start==i: # at first index when individual elements are present [a],[b],[c]
                    Solution.path.append(s[i])
                else:
                    Solution.path.append(s[start:i+1]) #all possible combintions of string 
                self.backtrack(s,i+1)
                Solution.path.pop()
                
        
   
    def palindrome(self,string,l,r):
        if l==r:
            return True
        while (l<r):
            if string[l]!=string[r]:
                return False
            l=l+1
            r=r-1
        return True