# Time Complexity: O(N*z^N)
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def ispal(self,s):
        if s==s[::-1]:
            return True
        return False

    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """

        res=[]
        path=[]

        def helper(pivot):
            if pivot == len(s):
                res.append(list(path))
                return
            
            for i in range(pivot, len(s)):
                sub_str=s[pivot:i+1]
                if self.ispal(sub_str):
                    path.append(sub_str)
                    helper(i+1)
                    path.pop()
        
        helper(0)
        return res
            

        