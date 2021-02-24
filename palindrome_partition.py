/Time Complexity: O(n* n^n), where n is to check palindrome
//Space Complexity: O(n) where n is max depth of tree
// Passed all test cases on Leetcode: Yes
// Approach: Make use of backtrackking recursion to keep updating the path array with various combinations of palindrome. Check palindrome or 
// not with 2 pointer approach

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        
        if(s==""):
            return([])
        
        self.op=[]
        self.backtrack(s,0,[])
        return(self.op)
    def backtrack(self,s, index, path):
        
        if(index>=len(s)):
            self.op.append(copy.deepcopy(path))
            
        
        for i in range(index,len(s)):
            cur=s[index:i+1]
            
            if(self.isPalindrome(cur)):
                path.append(cur)
                self.backtrack(s,i+1,path)
                del path[len(path)-1]
    
    def isPalindrome(self,s):
        left=0
        right=len(s)-1
        
        while(left<=right):
            if(s[left]!=s[right]):
                return(False)
            left+=1
            right-=1
        
        return(True)