  

// Time Complexity : O(n^n)
// Space Complexity : O(n^n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if not s or len(s)==0:
            return []
        self.output=[]
        path=[]
        self.backtracking(s,0,path)//call backtracing function with index=0
        return self.output
        
        
    def backtracking(self,s,index,path):
        if index>=len(s):       //if index is >length of string => we have the list which contains substrings which are palindrom as well so directly appened teh path list to output list
            self.output.append(list(path))
            return
        
        for i in range(index,len(s)):   //if index <length of string => current substring will be all the characters from index value index till index value i
            curr=s[index:i+1]
            if self.isPalindrom(curr):  //check if current string is palindrom if yes then append it to path list and call the backtracing function with index=i+1 otherwise do nothing
                path.append(curr)
                self.backtracking(s,i+1,path)
                path.pop()
        
        
    def isPalindrom(self,curr):     //this function will check whether current string is palindrom or not
        left=0
        right=len(curr)-1
        while left<right:
            if curr[left]!=curr[right]:
                return False
            left+=1
            right-=1
        return True
