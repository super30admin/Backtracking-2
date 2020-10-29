"""
Time - O(N * 2^N)
Space - O(N)
Leetcode - yes
Problems - no
"""
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        result = []
        stack = []
        
        
        def dfs(s, start, stack):
            
            if(start >= len(s)):
                if(stack not in result):
                    result.append(list(stack))
                return
            

            for end in range(start, len(s)):
                if(is_pal(s, start, end)):
                    stack.append(s[start:end+1])
                    dfs(s, end+1, stack)
                    stack.pop()
            
            return
        
        def is_pal(s, start, end):
            
            while(start < end):
                if(s[start] != s[end]):
                    return False
                start += 1
                end -= 1
            
            return True
        
        
        dfs(s, 0, stack)
        return result