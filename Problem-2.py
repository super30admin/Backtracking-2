# Time Complexity :O(2^n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    #check is string is palindrome
    def ispalindrome(self,temp):
        if not temp:
            return False
        start = 0
        end = len(temp)-1
        while start < end:
            if temp[start] != temp[end]:
                return False
            start +=1
            end -=1
        return True
    def backtrack(self,s,temp,index,res):
        #if all the string is used append a copy of it to res
        if index >= len(s):
            res.append(temp[::])
            return
        #iterate from index to end of string index starting at 0
        for i in range(index,len(s)):
            #if string from index to i is a palindrome append ot to temp 
            if(self.ispalindrome(s[index:i+1])):
                temp.append(s[index:i+1])
                #backtrack on rest
                self.backtrack(s,temp,i+1,res)
                #pop last action taken
                temp.pop()
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        # create result backtrack and return it
        res = []
        self.backtrack(s,[],0,res)
        return res