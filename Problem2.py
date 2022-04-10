# Time Complexity : O(N * 2^N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        def dfsHelper(s, path, res):
            if not s:
                res.append(path[:])
                return
            
            for i in range(1,len(s)+1):
                if s[:i] == s[i-1::-1]:
                    path.append(s[:i])
                    dfsHelper(s[i:], path, res)
                    path.pop()        
        res = []
        dfsHelper(s, [], res)
        return res
                    