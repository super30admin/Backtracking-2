# Runs on Leetcode
    # Runtime - O()
    # Memory - O(1) without recursive stack


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if not s:
            return []
        self.result = []
        self.helper(s, 0, [])
        return self.result
    
    def palindrome(self, s):
        if s == s[::-1]:
            return True
        return False
        
    def helper(self,s, index, temp):
        # edge case
        if index > len(s):
            return
        if index == len(s):
            self.result.append(list(temp))
        
        # logic
        for i in range(index,len(s)):
            a = s[index:i+1]
            if self.palindrome(a):
                temp.append(a)
                self.helper(s, i+1, temp)
                # backtrack
                temp.pop()
