// Time Complexity :O(n*(2^n))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In this problem we implement backtracking by storing every possible substring and before storing we check they are palindrome or not.
# backtracking
class Solution(object):
    def __init__(self):
        self.out=[]
    def helper(self,s,list1,index):
        if index==len(s):
            self.out.append(list(list1))
            return
        for i in range(index,len(s)):
            if s[index:i+1]==s[index:i+1][::-1]:
                list1.append(s[index:i+1])
                self.helper(s,list1,i+1)
                list1.pop()
    
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        if s==None or len(s)==0:
            return []
        self.helper(s,[],0)
        return self.out
             
