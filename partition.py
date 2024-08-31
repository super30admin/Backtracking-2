
# time: O(n)
# space: O(1)

class Solution(object):
    result = []
    def partition(self, s):
        self.result = []
        self.helper(s, 0, [])
        return self.result
    
    def helper(self, s, pivot, path):
        if pivot >= len(s):
            new_path = []
            new_path += path
            self.result.append(new_path)
            return
        for i in range(pivot, len(s)):
            sub_str = s[pivot: i+1]
            if self.is_palindrome(sub_str):
                # action
                path.append(sub_str)
                # recurse
                self.helper(s, i+1, path)
                # backtarack
                path.pop()

    def is_palindrome(self, st):
        i, j = 0, len(st) - 1
        while i <= j:
            if st[i] != st[j]:
                return False
            i += 1
            j -= 1
        return True