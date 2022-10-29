# Time Complexity: O(n^2*n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


import copy
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        result = []
        if s == None or len(s) == 0:
            return result
                    
        def helper(s, index, path):
            
            def isPalindrome(t, start, end):
                
                while(start<=end):
                    if t[start]!=t[end]:
                        return False
                    start+=1
                    end-=1
                return True
        
            if index==len(s):
                result.append(list(path))

            for i in range(index, len(s)):
                if isPalindrome(s, index, i):
                    curr = s[index:i+1]
                    path.append(curr)
                    helper(s, i+1, path)
                    path.pop()
        
                    
        helper(s, 0, [])
        return result