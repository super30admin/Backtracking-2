#Time Complexity:O(nx2^n),as we are checking if it is a palindrome or not and then adding the obatined resultant to result.
#Space complexity:O(n)

#Did it run successfully on Leetocde:Yes
#Doubts: Not sure about the space complexity:
# Algorithm:
# 1. Create a backtrack function, where we are slicling the gven string, and checing if it is palindrome or not. If yes we add that to the result else, move further keeping that index as pivot in the given string and explore further.After we reach the end of the string we concatenate the prvious pivot with next element in string and repeat the same procedure.
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result=[]
        self.BT(s,[],0,result)
        return result
    def BT(self,s,curr,index,result):
        #base
        if index==len(s):
            result.append(list(curr))
        
        # logic
        for i in range(index,len(s)):
          action
            if self.isPalindrome(s[index:i+1]):
                curr.append(s[index:i+1])
            recurse
                self. BT(s,curr,i+1,result)
                    #backtrack
                curr.pop()
    def isPalindrome(self,s):
        return s==s[::-1]
    
#recursion solution:
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result=[]
        self.helper(s,[],0,result)
        return result
    def helper(self,s,curr,index,result):
        #base
        if index==len(s):
            result.append((curr))
        
        # logic
        for i in range(index,len(s)):
            if self.isPalindrome(s[index:i+1]):
             
                temp=[]
                temp=curr+[(s[index:i+1])]
                self. helper(s,temp,i+1,result)
              
    def isPalindrome(self,s):
        return s==s[::-1]
    
                
