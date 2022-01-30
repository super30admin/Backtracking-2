# SC : O(height of recursion or N ) as single elements is the max length of recursion
# TC : exponential but some what less than O(2^N)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        from copy import deepcopy
        
        def isPalindrome(s):
            last = len(s) -1
            first = 0
            while(first < last):
                if s[first] == s[last]:
                    first = first + 1
                    last = last - 1
                    continue
                else:
                    return False
            return True
        
        def recur(s, index, path):
            # BASE
            if index == len(s):
                res.append(deepcopy(path))
            
            # LOGIC
            for i in range(index, len(s)):
                substring = s[index : i + 1]
                if isPalindrome(substring):
                    path.append(substring)
                    # recurse from that i 
                    recur(s, i+1, path)
                    # remove element from path if added 
                    path.pop(-1)
        
        recur(s, 0, [])
        return res
        
            
        
        
