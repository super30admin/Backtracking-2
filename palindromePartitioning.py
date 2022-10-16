#Time Complexity: O(N*2^N)
#Space Complexity: O(N*2^N)
#Did it run on leetcode: Yes

class Solution(object):
    def __init__(self):
        self.memory = collections.defaultdict(list)
        
    def partition(self, s):
        if not s: return [[]]
        if s in self.memory: return self.memory[s]  # the memory trick can save some time
        ans = []
        for i in range(1, len(s) + 1):
            if s[:i] == s[:i][::-1]:  # prefix is a palindrome
                for suf in self.partition(s[i:]):  # process suffix recursively
                    ans.append([s[:i]] + suf)
        self.memory[s] = ans
        return ans