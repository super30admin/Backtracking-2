Palindrome Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

Time : 0(2^n) | Space :O(n)

class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.result = []
        if s == None or len(s) == 0:
            return result
        self.backtrack(s,[],0)
        return  self.result
    def backtrack(self,s,temp,index):
        #logic
        if index == len(s):
            self.result.append(list(temp))
        for i in range(index,len(s)):
            #action
            if self.isPalindrome(s,index,i):
                temp.append(s[index: i + 1])
                 #recurse
                self.backtrack(s,temp,i+1)
                #bactrack
                temp.pop()
    def isPalindrome(self,s,left,right):
        # check for palindrome using 2 pointers
        # if (right >= len(s)):
        #     return False

        while (left <= right):
            if (s[left] != s[right]):
                return False
            left += 1; right -= 1

        return True

                
            
      
        class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        if len(s) == 0 or s == None:
            return []
        self.result = []
        self.backtrack(s,[],0)
        return self.result
    def backtrack(self,s,temp,index):
        if index == len(s):
            self.result.append(list(temp))
        for i in range (index,len(s)):
            if self.isPalindrome(s,index,i):
                temp.append(s[index: i + 1])
                self.backtrack(s,temp,i+1)
                temp.pop()
    def isPalindrome(self,s,left,right):
        # if right >= len(s):
        #     return False
        while(left <= right):
            if s[left] != s[right]:
                return False
            left += 1 
            right -= 1
            return True
        


    
