class Solution(object):
    def partition(self, s):
        ans = []
        self.helper(s, [], ans)
        return ans
        
    def helper(self, s, temp, ans):
        if not s:
            ans.append(temp)
        for i in range(len(s)):
            if s[:i+1] == s[:i+1][::-1]:
                self.helper(s[i+1:],temp+[s[:i+1]],ans)

        
