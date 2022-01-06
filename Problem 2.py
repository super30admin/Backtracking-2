# Time: O(n*n)
# Space: O(n*n)
class Solution(object):
    def __init__(self):
        self.ans = []
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.helper(0,s, [])
        return self.ans
    def helper(self, index, s, curr):
        print(curr)
        if index == len(s):
            self.ans.append(list(curr))
            return
        for i in range(index, len(s)):
            if s[index:i+1] == s[index:i+1][::-1]:
                curr.append(s[index:i+1])
                self.helper(i+1, s, curr)
                curr.pop()
        
