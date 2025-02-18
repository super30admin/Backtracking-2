# BackTrack
# Time Complexity: O(n 2^n)
# Space Complexity: O(n 2^n)
from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if len(s) == 0:
            return []
        result = []
        def isPalindrome(s, l, r):
            while l<= r:
                if s[l] != s[r]:
                    return False
                l = l+1
                r = r - 1
            return True
        def recurse(s, index, path):
            # base case
            if index == len(s):
                newlist = list(path)
                result.append(newlist)
                return
            
            # Logic

            for i in range(index, len(s)):
                if isPalindrome(s,index,i):
                    path.append(s[index : i+1])
                    recurse(s, i+1, path)
                    path.pop()


        recurse(s,0,[])
        return result

        