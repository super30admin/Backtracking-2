# Time Complexity : O(n2^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []

        cur_par = []
        def isPalindrome(substring):
            l,r = 0, len(substring) - 1
            while l < r:
                if substring[l] != substring[r]:
                    return False
                l += 1
                r -= 1
            return True

        def recurse(pivot):
            #base
            if pivot == len(s):
                res.append(cur_par[::])
                return
            
            #logic
            for i in range(pivot, len(s)):
                cur_split = s[pivot:i+1]
                if isPalindrome(cur_split):
                    cur_par.append(cur_split)
                    recurse(i+1)
                    cur_par.pop()
        
        recurse(0)
        return res