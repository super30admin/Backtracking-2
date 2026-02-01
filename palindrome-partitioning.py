#--------Solution 1 : For loop based recursion------------
''' Time Complexity : O(n* 2^n)) ;  n = len of the list and O(n) to palindrome check
    Space Complexity : O(n^2)  : recursion stack + substring creation
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []

        def helper(s, pivot, path):
            #base
            if pivot == len(s):
                self.result.append(list(path))

            #logic
            for i in range(pivot,len(s)):
                sub = s[pivot:i+1]
                if self.isPalindrome(sub):
                    #action
                    path.append(sub)
                    #recurse
                    helper(s,i+1,path)
                    #backtrack
                    path.pop()

        helper(s,0,[])
        return self.result
    
    def isPalindrome(self, sub):
        l, r = 0, len(sub)-1
        while l < r:
            if sub[l] != sub[r]:
                return False
            l += 1
            r -= 1
        return True