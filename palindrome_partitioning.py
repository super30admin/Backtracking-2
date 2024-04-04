# Time Complexity : O(n*2^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def helper(pivot, path : List[str]):
            if pivot == len(s):
                result.append(path.copy())
                return 
            
            for i in range(pivot, len(s)):
                sub = s[pivot:i+1]
                if(isPalindrome(sub)):
                    path.append(sub)
                    helper(i+1, path)
                    path.pop()
        
        def isPalindrome(s):
            start = 0
            end = len(s)-1

            while(start < end):
                if(s[start] != s[end]):
                    return False
                start+=1
                end-=1
            
            return True
        
        helper(0, [])
        return result

#choose-not choose
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def helper(pivot, i, path : List[str], count):
            if i == len(s):
                if count == len(s):
                    result.append(path.copy())
                return 
            
            helper(pivot, i+1, path, count)

            substr = s[pivot:i+1]
            if(isPalindrome(substr)):
                path.append(substr)
                helper(i+1, i+1, path, count+len(substr))
                path.pop()
        
        def isPalindrome(s):
            start = 0
            end = len(s)-1

            while(start < end):
                if(s[start] != s[end]):
                    return False
                start+=1
                end-=1
            
            return True
        
        helper(0, 0, [], 0)
        return result

        

        