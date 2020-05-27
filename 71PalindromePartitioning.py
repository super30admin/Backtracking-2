"""
// Time Complexity :O(n*2^n) Visiting each node ones.
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NA

//Explanation:
Partition the input string. If the original string isPalindrome, add it in temp list
and then only add remaining characters in the input string using recursion.
pop the element from the temp list.

In recursive approach, create new list at each state.
"""
class Solution:
    def __init__(self):
            self.result = [ ]
            self.temp = []
    def partition(self, s: str) -> List[List[str]]:
        if s is None and len(s) == 0:
            return result

        self.backtrack(s,[ ],0)
        return self.result


    def backtrack(self,s,temp,start):
        # base
        if start == len(s):
            self.result.append(list(self.temp))
            return

        for i in range(start,len(s)):
            if self.isPalindrome(s,start,i):
                #print(s[start:i+1])
                #action
                self.temp.append(s[start:i+1])
                #print(self.temp)
                #recursion
                self.backtrack(s,self.temp,i+1)
                #backtrack
                self.temp.pop()

    """
    T = O(n*2^n)
     T =S(n*2^n)
    # recursive approach
    def backtrack(self,s,temp,start):
        # base
        if start == len(s):
            self.result.append(temp)
            return

        for i in range(start,len(s)):
            if self.isPalindrome(s,start,i):
                #action
                newList = list(temp)         #create new list each time
                newList.append(s[start:i+1])

                #recursion
                self.backtrack(s,newList,i+1)

                #backtrack -> NOT REQUIRED
                #self.temp.pop()
    """


    def isPalindrome(self,s,l,r):
        if l == r: return True
        while(l<r):
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True
