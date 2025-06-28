# Time complexity - o(n2^n)
# Space complexity - o(n)

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        res = []

        def helper(pivot, path, count, res):

            if count == len(s):
                res.append(path[:])
                return

            if pivot == len(s):
                return
            

            for i in range(pivot,len(s)):
                if isPalindrome(s[pivot:i+1]):
                    #action
                    path.append(s[pivot:i+1])

                    #recurse
                    helper(i+1, path, count+len(s[pivot:i+1]), res)
                    #backtrack
                    path.pop()

        
        def isPalindrome(s):
            n = len(s)
            for i in range(n//2):
                if s[i]!=s[n-i-1]:
                    return False
            return True

        helper(0, [], 0, res)
        return res