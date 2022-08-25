# Time Complexity : O(2^N) Number of characters in string
#  Space Complexity : O(N) Space taken by stack
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach
#T.C  O(2^n)?
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        #Declare the lsit o retu the esult
        res = []
        
        #Base case
        if not s:
            return []
        #To check if string is palindrome
        def isPalindrome(s, left, right):
            while left <= right:
                if s[left] != s[right]:
                    return False
                left +=1
                right -=1
            return True
        
        #Function to backtrack the result for each set
        def helper(s,index,path):
            if index >= len(s):
                res.append(path.copy())
                return
            
            #Logic- Check if the pallindrome is there or not if yes then populate the path then backtrack 
            for i in range(index,len(s)):
                if isPalindrome(s, index, i):
                    path.append(s[index:i+1])
                    helper(s,i + 1,path)
                    
                    #backtrack
                    path.pop()
        helper(s, 0,[])
        return res