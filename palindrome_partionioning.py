class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        self.helper(s, 0, sub = [])
        return self.res
    def helper(self, s, pivot, sub):
        if pivot == len(s):
            self.res.append(sub.copy())
            return

        for i in range(pivot, len(s)):
            curr = s[pivot:i+1]
            print(curr, pivot)
            if self.isPalindrome(curr):
                sub.append(curr)
                self.helper(s, i+1, sub)
                sub.pop()

    def isPalindrome(self, str1):
        if len(str1)%2 == 1:
            n = len(str1)//2
            for i in range(1,n+1):
                if str1[n-i] != str1[n+i]:
                    return False
        else:
            n = len(str1)//2
            for i in range(0,n):
                if str1[n-1-i] != str1[n+i]:
                    return False
        return True

        