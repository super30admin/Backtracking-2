# Time Complexity : L*2^L (L is length of string)
# Space Complexity : L 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def helper(idx,path):
            #base
            if idx == len(s):
                result.append(list(path))
                return

            #logic
            for i in range(idx,len(s)):
                substr = s[idx:i+1]
                if substr == substr[::-1]:
                    path.append(substr)
                    helper(i+1,path)
                    path.pop()
        helper(0,[])
        return result

